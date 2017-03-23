package com.lanling.utils;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;

/**
 * The Class load the external jars
 *
 * @author Lanling
 *         on 2017-03-18
 */
public class JarsLoader {

    public static final String mysqlDriver =
            "C:\\Users\\Administrator\\.m2\\repository\\mysql\\mysql-connector-java\\5.1.38\\mysql-connector-java-5.1.38.jar";

    public static void loadJars(String... jarPaths) {
        try {
            if (jarPaths != null && jarPaths.length > 0) {
                int length = jarPaths.length;
                List<URL> urlList = new ArrayList<>(length);
                for (String jarPath : jarPaths) {
                    File file = new File(jarPath);
                    if (file.exists() && file.isFile()) {
                        URL url = file.toURI().toURL();
                        urlList.add(url);
                    }
                }
                URLClassLoader loader = new URLClassLoader(urlList.toArray(new URL[urlList.size()]), Thread.currentThread().getContextClassLoader());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
