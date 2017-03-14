package com.gigaspaces.gigapro;

import com.gigaspaces.gigapro.destination.L;
import com.gigaspaces.gigapro.source.N;
import com.j_spaces.core.IJSpace;
import com.j_spaces.core.admin.StatisticsAdmin;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openspaces.admin.Admin;
import org.openspaces.admin.AdminFactory;
import org.openspaces.admin.space.Space;
import org.openspaces.core.GigaSpace;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * @author Svitlana_Pogrebna
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/test-context.xml")
public class ReplicationTest {
    @Resource
    private GigaSpace sourceSpace;
    @Resource
    private GigaSpace destinationSpace;
    
    @Resource
    private SessionFactory sessionFactory;
    
    private Admin admin;
    private Space srcSpace;
    private Space destSpace;
    
    private long timeout = 10000;
    
    @Before
    public void setup() {
        AdminFactory adminFactory = new AdminFactory();
        admin = adminFactory.createAdmin();
        if (admin == null) {
            throw new RuntimeException("Can't locate admin");
        }
        srcSpace = admin.getSpaces().waitFor("NYSpace", 10, TimeUnit.SECONDS);
        if (srcSpace == null) {
            throw new RuntimeException("Can't locate space " + sourceSpace.getName());
        }
        destSpace = admin.getSpaces().waitFor("LondonSpace", 10, TimeUnit.SECONDS);
        if (destSpace == null) {
            throw new RuntimeException("Can't locate space " + destinationSpace.getName());
        }
    }
    
    @After
    public void teardown() {
        admin.close();
    }
    
    @Test
    public void testSourceObject() {
        N n = ObjectFactory.create(N.class);
        sourceSpace.write(n);
        
        String id = n.getId();
    
        // wait for replica to WAN GW and Mirror targets
        waitForEmptyReplicationBacklog(srcSpace.getGigaSpace().getSpace());
        N replicated = selectById(N.class, id);
        assertNotNull("Object was not persisted to db", replicated);
        assertEquals(n, replicated);
        
        replicated = destinationSpace.readById(N.class, id, id, timeout);
        assertNotNull("Object creation action was not replicated to destination space", replicated);
        assertEquals(n, replicated);
        
        n.getApplication().setA("updated value");
        sourceSpace.write(n); //update
        
        // wait for replica to WAN GW and Mirror targets
        waitForEmptyReplicationBacklog(srcSpace.getGigaSpace().getSpace());
        assertEquals("Object was not updated in db", n, selectById(N.class, id));
        assertEquals("Object update action was not replicated to destination space", n, destinationSpace.readById(N.class, id, id));
        
        sourceSpace.takeById(N.class, id); 
        
        // wait for replica to WAN GW and Mirror targets
        waitForEmptyReplicationBacklog(srcSpace.getGigaSpace().getSpace());
        assertNull("Object was not removed from db", selectById(N.class, id)); 
        assertNull("Object remove action was not replicated to destination space", destinationSpace.readIfExistsById(N.class, id, id));
        
    }

    @Test
    public void testDestinationObject() {
        L l = ObjectFactory.create(L.class);
        sourceSpace.write(l); //create
        
        String id = l.getId();
        // wait for replica to WAN GW target
        waitForEmptyReplicationBacklog(srcSpace.getGigaSpace().getSpace());
        
        L replicated = destinationSpace.readById(L.class, id, id);
        assertNotNull("Object creation action was not replicated to destination space", replicated);
        assertEquals(l, replicated);
    
        // wait for replica to Mirror target
        waitForEmptyReplicationBacklog(destSpace.getGigaSpace().getSpace());
        replicated = selectById(L.class, id);
        assertNotNull("Object was not persisted to db", replicated);
        assertEquals(l, replicated);
        
        l.setC("updated value");
        
        sourceSpace.write(l); //update
        
        // wait for replica to WAN GW target
        waitForEmptyReplicationBacklog(srcSpace.getGigaSpace().getSpace());
        assertEquals("Object update action was not replicated to destination space", l, destinationSpace.readById(L.class, id, id));
        
        // wait for replica to Mirror target
        waitForEmptyReplicationBacklog(destSpace.getGigaSpace().getSpace());
        assertEquals("Object was not updated in db", l, selectById(L.class, id));
        
        sourceSpace.takeById(L.class, id); 
       
        // wait for replica to WAN GW target
        waitForEmptyReplicationBacklog(srcSpace.getGigaSpace().getSpace());
        assertNull("Object remove action was not replicated to destination space", destinationSpace.readIfExistsById(L.class, id, id));
        
        // wait for replica to Mirror target
        waitForEmptyReplicationBacklog(destSpace.getGigaSpace().getSpace());
        assertNull("Object was not removed from db", selectById(L.class, id)); 
    }
    
    
    private <T> T selectById(Class<? extends T> clazz, String id) {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            return (T) session.get(clazz, id);
        } finally {
            if (session != null) session.close();
        }
    }
    /**
     * Copied from https://raw.githubusercontent.com/Gigaspaces/mongo-datasource-itests/master/itests/src/test/java/com/gigaspaces/persistency/qa/stest/AbstractSystemTestUnit.java 
     * @param space
     */
    private void waitForEmptyReplicationBacklog(final IJSpace space) {
        Assert.assertTrue("replication backlog is not 0", repeat(new IRepetitiveRunnable() {
            @Override
            public void run() throws Exception {
                long l = ((StatisticsAdmin) space.getAdmin()).getHolder()
                            .getReplicationStatistics()
                            .getOutgoingReplication()
                            .getRedoLogSize();
                Assert.assertEquals("backlog not empty", 0, l);
            }
        }, timeout));
    }

    private boolean repeat(IRepetitiveRunnable repetitiveRunnable, long repeateInterval) {
        return repeat(repetitiveRunnable, repeateInterval, 4);
    }

    private boolean repeat(IRepetitiveRunnable repetitiveRunnable, long repeatInterval, int timesToRepeat) {
        int leftToRepeat = timesToRepeat;
        try {
            Thread.sleep(repeatInterval);
        } catch (InterruptedException e2) {
        }
        while (true) {
            try {
                repetitiveRunnable.run();
                break;
            } catch (Throwable e) {
                try {
                    Thread.sleep(repeatInterval);
                    leftToRepeat--;
                    if (leftToRepeat == 0)
                        break;
                } catch (InterruptedException e1) {
                    leftToRepeat--;
                    if (leftToRepeat == 0)
                        break;
                }
            }
        }
        return leftToRepeat > 0;
    }
    
    private static interface IRepetitiveRunnable {
        void run() throws Exception;
    }
}
