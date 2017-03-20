package com.lanling.utils;

import java.sql.*;

/**
 * The Class database connection util
 *
 * @author Lanling
 *         on 2017-03-18
 */
public class DBConnUtil {

    /**
     * open database connection
     *
     * @param databaseType database type
     * @param url          url
     * @param username     username
     * @param password     password
     * @return connection
     */
    public static Connection getConnection(int databaseType, String url, String username, String password) {
        Connection conn = null;
        try {
            if (databaseType < 0 || databaseType > 10)
                databaseType = 0;
            Class.forName(DatabaseDriver.values()[databaseType].getDriverClassName());
        } catch (Exception e) {
            return null;
        }
        try {
            conn = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
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
