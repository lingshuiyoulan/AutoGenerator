package com.lanling.generator;

import com.lanling.generator.database.Database;
import com.lanling.generator.database.Field;
import com.lanling.generator.database.Table;
import com.lanling.utils.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * The Class
 *
 * @author Lanling
 *         on 2017-03-18
 */
public class Test {

    public static final String mysqlDriver = "D:/Util/JAR/mysql-connector-java-5.1.38.jar";

    @org.junit.Test
    public void test() throws SQLException {

        ClassLoader classLoader = ClassLoaderUtil.getCustomClassloader(mysqlDriver);
        ObjectFactory.addExternalClassLoader(classLoader);

        JDBCConnectionConfig config = new JDBCConnectionConfig();
        config.setConnectionURL("jdbc:mysql://localhost:3306/lanling?useSSL=true");
        config.setDriverClass(DatabaseDriver.MYSQL.getDriverClassName());
        config.setUserId("root");
        config.setPassword("lanling");

        JDBCConnectionUtil jdbcConnectionUtil = new JDBCConnectionUtil(config);

        Connection connection = jdbcConnectionUtil.getConnection();

        Database database = IntrospectUtil.getTableList(connection);
        List<Table> tableList = database.getTableList();
        for (Table table:tableList) {
            System.out.println(table.getName());
            List<Field> fieldList = table.getFieldList();
            for (Field field:fieldList) {
                System.out.print(field.getName()+field.getType()+" ");
            }
            System.out.println();
        }
    }
}
