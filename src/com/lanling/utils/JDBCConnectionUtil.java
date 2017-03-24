package com.lanling.utils;

import java.sql.*;
import java.util.Properties;

import static com.lanling.utils.StringUtility.stringHasValue;

/**
 * The Class database connection util
 *
 * @author Lanling
 *         on 2017-03-18
 */
public class JDBCConnectionUtil {

    private String userId;
    private String password;
    private String connectionURL;
    private String driverClass;

    public JDBCConnectionUtil(JDBCConnectionConfig config) {
        super();
        userId = config.getUserId();
        password = config.getPassword();
        connectionURL = config.getConnectionURL();
        driverClass = config.getDriverClass();
    }

    /**
     * open database connection
     *
     * @return connection
     */
    public Connection getConnection() throws SQLException {

        Driver driver = getDriver();

        Properties props = new Properties();

        if (stringHasValue(userId)) {
            props.setProperty("user", userId); //$NON-NLS-1$
        }

        if (stringHasValue(password)) {
            props.setProperty("password", password); //$NON-NLS-1$
        }

        return driver.connect(connectionURL, props);
    }

    /**
     * get database driver
     *
     * @return driver
     */
    private Driver getDriver() {
        Driver driver = null;
        try {
            Class<?> clazz = ObjectFactory.externalClassForName(driverClass);
            driver = (Driver) clazz.newInstance();
        } catch (Exception e) {
        }

        return driver;
    }

    public static void free(Connection conn, Statement stmt, ResultSet rs) {
        try {
            if (rs != null) rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (conn != null) conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
