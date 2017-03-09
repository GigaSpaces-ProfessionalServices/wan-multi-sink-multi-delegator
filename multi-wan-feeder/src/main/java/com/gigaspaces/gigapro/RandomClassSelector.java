package com.gigaspaces.gigapro;

import com.gigaspaces.gigapro.source.*;
import com.gigaspaces.gigapro.destination.*;

import java.util.*;
import java.util.Map.Entry;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author Svitlana_Pogrebna
 *
 */
public class RandomClassSelector {

    private static final Map<Class<?>, Double> objectsCountMap;
    static {
        Map<Class<?>, Double> objectsMutableMap = new HashMap<>();
        objectsMutableMap.put(F1.class, 72d);
        objectsMutableMap.put(TT.class, 22d);
        objectsMutableMap.put(F3.class, 106d);
        objectsMutableMap.put(SS.class, 72d);
        objectsMutableMap.put(U1.class, 72d);
        objectsMutableMap.put(D3.class, 279d);
        objectsMutableMap.put(M1.class, 72d);
        objectsMutableMap.put(I2.class, 323d);
        objectsMutableMap.put(E1.class, 72d);
        objectsMutableMap.put(RR.class, 68d);
        // objectsMutableMap.put(F2.class, 277d);
        objectsMutableMap.put(B1.class, 98d);
        objectsMutableMap.put(O1.class, 0.027);
        objectsMutableMap.put(XX.class, 142d);
        objectsMutableMap.put(WW.class, 5500d);
        objectsMutableMap.put(S.class, 3.5);
        objectsMutableMap.put(K3.class, 197d);
        objectsMutableMap.put(H1.class, 9.796);
        objectsMutableMap.put(E3.class, 279d);
        objectsMutableMap.put(G1.class, 146d);
        objectsMutableMap.put(C3.class, 279d);
        objectsMutableMap.put(K1.class, 168d);
        objectsMutableMap.put(V3.class, 1900d);
        // objectsMutableMap.put(C1.class, 1200d);
        objectsMutableMap.put(A1.class, 72d);
        objectsMutableMap.put(H3.class, 226d);
        // objectsMutableMap.put(V2.class, 22d);
        objectsMutableMap.put(P1.class, 24d);
        objectsMutableMap.put(J3.class, 6100d);
        objectsMutableMap.put(R2.class, 134d);
        objectsMutableMap.put(K2.class, 134d);
        objectsMutableMap.put(N2.class, 699d);
        objectsMutableMap.put(YY.class, 177d);
        objectsMutableMap.put(S3.class, 164d);
        // objectsMutableMap.put(U2.class, 1300d);
        objectsMutableMap.put(D2.class, 1100d);
        objectsMutableMap.put(VV.class, 706d);
        objectsMutableMap.put(J1.class, 32d);
        objectsMutableMap.put(O3.class, 278d);
        objectsMutableMap.put(N3.class, 278d);
        objectsMutableMap.put(D1.class, 0.331d);
        // objectsMutableMap.put(T2.class, 1300d);
        objectsMutableMap.put(Z1.class, 699d);
        objectsMutableMap.put(ZZ.class, 72d);
        objectsMutableMap.put(AA.class, 50d);
        objectsMutableMap.put(J.class, 30d);
        objectsMutableMap.put(N.class, 100d);
        objectsMutableMap.put(DD.class, 10d);
        objectsMutableMap.put(F.class, 1001d);
        objectsMutableMap.put(G3.class, 81d);
        objectsCountMap = Collections.unmodifiableMap(objectsMutableMap);
    }
    private static final double totalWeight;
    private static final NavigableMap<Double, Class<?>> objectsWeightIntervalMap;
    static {
        objectsWeightIntervalMap = new TreeMap<>();
        double total = 0;
        for (Entry<Class<?>, Double> entry : objectsCountMap.entrySet()) {
            total += entry.getValue();
            objectsWeightIntervalMap.put(total, entry.getKey());
        }
        totalWeight = total;
    }

    public static final Class<?> get() {
        return objectsWeightIntervalMap.ceilingEntry(ThreadLocalRandom.current().nextDouble() * totalWeight).getValue();
    }
}
