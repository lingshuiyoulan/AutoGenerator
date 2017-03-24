package com.lanling.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * The Class load the class
 *
 * @author Lanling
 *         on 2017-03-18
 */
public class ObjectFactory {

    private static List<ClassLoader> externalClassLoaders;

    private ObjectFactory() {
    }

    static {
        externalClassLoaders = new ArrayList<>();
    }

    public static synchronized void addExternalClassLoader(ClassLoader classLoader) {
        externalClassLoaders.add(classLoader);
    }

    public static void reset() {
        externalClassLoaders.clear();
    }

    public static Class<?> externalClassForName(String type) throws ClassNotFoundException{
        Class<?> clazz;

        for (ClassLoader classLoader : externalClassLoaders) {
            try {
                clazz = Class.forName(type, true, classLoader);
                return clazz;
            } catch (Throwable e) {
            }
        }

        return internalClassForName(type);
    }

    /**
     * Internal class for name
     *
     * @param type
     *            the type
     * @return the class
     * @throws ClassNotFoundException
     *             the class not found exception
     */
    public static Class<?> internalClassForName(String type) throws ClassNotFoundException{
        Class<?> clazz = null;

        try {
            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
            clazz = Class.forName(type, true, classLoader);
        } catch (Exception e) {
        }

        if (clazz == null) {
            clazz = Class.forName(type, true, ObjectFactory.class.getClassLoader());
        }
        return clazz;
    }
}
