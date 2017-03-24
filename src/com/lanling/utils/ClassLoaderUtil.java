package com.lanling.utils;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;

/**
 * The Class
 *
 * @author Lanling
 *         on 2017-03-18
 */
public class ClassLoaderUtil {

    /**
     * get custom classloader
     * @param classPaths the path of class or jar
     * @return classloader
     */
    public static ClassLoader getCustomClassloader(String ... classPaths) {

            if (classPaths != null && classPaths.length > 0) {
                int length = classPaths.length;
                List<URL> urlList = new ArrayList<>(length);
                for (String jarPath : classPaths) {
                    File file = new File(jarPath);
                    if (file.exists() && file.isFile()) {
                        URL url = null;
                        try {
                            url = file.toURI().toURL();
                        } catch (MalformedURLException e) {
                        }
                        urlList.add(url);
                    }
                }
                return new URLClassLoader(urlList.toArray(new URL[urlList.size()]), Thread.currentThread().getContextClassLoader());
            }
        return null;
    }
}
