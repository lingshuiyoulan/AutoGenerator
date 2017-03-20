package com.lanling.generator.database;

/**
 * The Class database data type
 *
 * @author Lanling
 *         on 2017-03-18
 */
public enum Type {
    BIT(-7),

    TINYINT(-6),

    SMALLINT(5),

    INTEGER(4),

    BIGINT(-5),

    FLOAT(6),

    REAL(7),

    DOUBLE(8),

    NUMERIC(2),

    DECIMAL(3),

    CHAR(1),

    VARCHAR(12),

    LONGVARCHAR(-1),

    DATE(91),

    TIME(92),

    TIMESTAMP(93),

    BINARY(-2),

    VARBINARY(-3),

    LONGVARBINARY(-4),

    NULL(0),

    OTHER(1111),

    JAVA_OBJECT(2000),

    DISTINCT(2001),

    STRUCT(2002),

    ARRAY(2003),

    BLOB(2004),

    CLOB(2005),

    REF(2006),

    DATALINK(70),

    BOOLEAN(16),

    ROWID(-8),

    NCHAR(-15),

    NVARCHAR(-9),

    LONGNVARCHAR(-16),

    NCLOB(2011),

    SQLXML(2009),

    REF_CURSOR(2012),

    TIME_WITH_TIMEZONE(2013),

    TIMESTAMP_WITH_TIMEZONE(2014);

    private int value;

    private Type(int value) {
        this.value = value;
    }

    public static Type getType(int type) {
        for (Type temp : Type.values()) {
            if (temp.value == type) {
                return temp;
            }
        }
        return null;
    }
}
