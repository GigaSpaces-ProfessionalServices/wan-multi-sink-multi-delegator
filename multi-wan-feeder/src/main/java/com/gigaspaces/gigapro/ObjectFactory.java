package com.gigaspaces.gigapro;

import com.gigaspaces.gigapro.source.*;
import com.gigaspaces.gigapro.destination.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.math.BigInteger;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Logger;

/**
 * @author Svitlana_Pogrebna
 *
 */
public class ObjectFactory {
    
    private static final Logger LOG = Logger.getLogger(ObjectFactory.class.getName());
    
    public static final Set<Class<?>> supportedClasses = Collections.unmodifiableSet(new HashSet<>(Arrays.asList(A.class, A1.class, A2.class, A3.class, AA.class, B.class, B1.class, B3.class, BB.class, C.class, C1.class, C2.class, C3.class, CC.class, D.class, D1.class, D2.class, D3.class, DD.class, E.class, E1.class, E2.class, E3.class, EE.class, F.class, F1.class, F2.class, F3.class, FF.class, G.class, G1.class, G2.class, G3.class, GG.class, H.class, H1.class, H2.class, H3.class, HH.class, I.class, I1.class, I2.class, I3.class, II.class, J.class, J1.class, J2.class, J3.class, JJ.class, K.class, K1.class, K2.class, K3.class, KK.class, L.class, L1.class, L2.class, L3.class, LL.class, M.class, M1.class, M2.class, M3.class, MM.class, N.class, N2.class, N3.class, NN.class, O.class, O1.class, O2.class, O3.class, OO.class, P.class, P1.class, P2.class, P3.class, PP.class, Q.class, Q1.class, Q2.class, Q3.class, QQ.class, R.class, R1.class, R2.class, R3.class, RR.class, S.class, S1.class, S2.class, S3.class, SS.class, T.class, T1.class, T2.class, T3.class, TT.class, U.class, U1.class, U2.class, U3.class, UU.class, V.class, V2.class, V3.class, VV.class, W.class, W2.class, W3.class, WW.class, X.class, X1.class, X2.class, X3.class, XX.class, Y.class, Y1.class, Y2.class, Y3.class, YY.class, Z.class, Z1.class, Z2.class, ZZ.class)));
    
    private static final int MAX_NUMBER = 10_000_000;
    
    public static final <T> T create(Class<? extends T> clazz) {
        if (!supportedClasses.contains(clazz)) {
            return null;
        }
        T instance;
        try {
            instance = clazz.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            LOG.severe(e.getMessage());
            throw new IllegalStateException("Failed to create an object of " + clazz.getName());
        }
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            if (!method.getName().startsWith("set")) {
                continue;
            }
            try {
                method.invoke(instance, generateValue(method.getParameterTypes()[0], method.getGenericParameterTypes()[0]));
            } catch (InvocationTargetException | IllegalAccessException | IllegalArgumentException e) {
                LOG.severe("Failed to generate value for '" + method.getName() + "' method parameter: " + e.getMessage());
            }
        }
        return instance;
    }
    
    private static final Object generateValue(Class<?> type, Type genericType) {
        if (type.isPrimitive() || type.isArray()) {
            throw new UnsupportedOperationException("unsupported type: " + type.getName());
        }
        ThreadLocalRandom random = ThreadLocalRandom.current();
        if (Integer.class.isAssignableFrom(type)) {
            return random.nextInt(0, MAX_NUMBER);
        }
        if (BigInteger.class.isAssignableFrom(type)) {
            return BigInteger.valueOf(random.nextLong(0, MAX_NUMBER));
        }
        if (Long.class.isAssignableFrom(type)) {
            return random.nextLong(0, MAX_NUMBER);
        }
        if (Double.class.isAssignableFrom(type)) {
            return random.nextDouble(0, MAX_NUMBER);
        }
        if (Float.class.isAssignableFrom(type)) {
            return Double.valueOf(random.nextDouble(0, MAX_NUMBER)).floatValue();
        }
        if (Boolean.class.isAssignableFrom(type)) {
            return random.nextBoolean();
        }
        if (String.class.isAssignableFrom(type)) {
            return UUID.randomUUID().toString();
        }
        if (Date.class.isAssignableFrom(type)) {
            return new Date(System.currentTimeMillis());
        }
        if (List.class.isAssignableFrom(type) && genericType instanceof ParameterizedType) {
            Class<?> actualType = (Class<?>)((ParameterizedType)genericType).getActualTypeArguments()[0];
            int count = random.nextInt(1, 5);
            List<Object> data = new ArrayList<>(count);
            for (int i = 0; i < count; i++) {
                data.add(create(actualType));
            }
            return data;
        }
        if (supportedClasses.contains(type)) {
            return create(type);
        }
        return null;
    }
}
