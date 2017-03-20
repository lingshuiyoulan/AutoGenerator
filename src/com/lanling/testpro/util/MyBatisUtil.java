package com.lanling.testpro.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

public class MyBatisUtil {
    private static ThreadLocal<SqlSession> local = new ThreadLocal<SqlSession>();
    private static SqlSessionFactory factory;

    static {
        try {
            Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
            factory = new SqlSessionFactoryBuilder().build(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static SqlSession getSqlSession() {
        SqlSession session = local.get();
        if (session == null) {
            session = (factory != null) ? factory.openSession() : null;
            local.set(session);
        }
        return session;
    }

    public static void close() {
        SqlSession session = local.get();
        local.set(null);
        if (session != null)
            session.close();
    }
}
