package com.lanling.utils;

/**
 * The Class database driver
 *
 * @author Lanling
 *         on 2017-03-18
 */
public enum DatabaseDriver {
    MYSQL("com.mysql.jdbc.Driver"),
    ORACLE("");

    private final String driverClassName;

    DatabaseDriver(String driverClassName) {
        this.driverClassName = driverClassName;
    }

    public String getDriverClassName() {
        return driverClassName;
    }
}
