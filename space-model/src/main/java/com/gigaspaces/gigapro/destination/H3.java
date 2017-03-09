package com.gigaspaces.gigapro.destination;

import com.gigaspaces.annotation.pojo.SpaceClass;
import com.gigaspaces.annotation.pojo.SpaceId;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.persistence.*;

@SpaceClass
@Entity
@Table(name = "H3", schema = "DBO")
public class H3 {
    private String id;
    private B a;
    private B b;
    private List<M2> c;
    private List<M2> d;
    private List<M2> e;
    private Date f;
    private Map<String, String> g;

    @Id
    @SpaceId(autoGenerate = false)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    @ManyToOne(cascade = {CascadeType.MERGE})
    public B getA() {
        return a;
    }

    public void setA(B a) {
        this.a = a;
    }
    
    @ManyToOne(cascade = {CascadeType.MERGE})
    public B getB() {
        return b;
    }

    public void setB(B b) {
        this.b = b;
    }

    @OneToMany(cascade = {CascadeType.MERGE})
    public List<M2> getC() {
        return c;
    }

    public void setC(List<M2> c) {
        this.c = c;
    }
    
    @Transient
    public List<M2> getD() {
        return d;
    }

    public void setD(List<M2> d) {
        this.d = d;
    }

    @Transient
    public List<M2> getE() {
        return e;
    }

    public void setE(List<M2> e) {
        this.e = e;
    }

    public Date getF() {
        return f;
    }

    public void setF(Date f) {
        this.f = f;
    }
    @Transient
    public Map<String, String> getG() {
        return g;
    }

    public void setG(Map<String, String> g) {
        this.g = g;
    }
}