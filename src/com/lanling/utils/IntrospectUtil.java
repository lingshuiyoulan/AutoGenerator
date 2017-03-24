package com.lanling.utils;

import com.lanling.generator.database.Database;
import com.lanling.generator.database.Field;
import com.lanling.generator.database.Table;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * The Class introspect
 *
 * @author Lanling
 *         on 2017-03-18
 */
public class IntrospectUtil {
    public static Database getTableList(Connection conn) {
        Database db = new Database();
        List<Table> tableList = new ArrayList<>();
        db.setTableList(tableList);
        Table table = null;
        List<Field> fieldList = null;
        Field field = null;
        ResultSet tables = null;
        ResultSet columns = null;
        try {
            DatabaseMetaData dbmd = conn.getMetaData();
            tables = dbmd.getTables(null, "lanling", null, null);
            while (tables.next()) {
                String tableName = tables.getString("TABLE_NAME");
                String tableType = tables.getString("TABLE_TYPE");
                table = new Table();
                tableList.add(table);
                table.setName(tableName);
                table.setType(tableType);
            }
            for (int i = 0; i < tableList.size(); i++) {
                Table tableTemp = tableList.get(i);
                fieldList = new ArrayList<>();
                columns = dbmd.getColumns(null, null, tableTemp.getName(), null);
                while (columns.next()) {
                    String fieldName = columns.getString("COLUMN_NAME");
                    String fieldType = columns.getString("DATA_TYPE");
                    field = new Field();
                    fieldList.add(field);
                    field.setName(fieldName);
                    field.setType(fieldType);
                }
                tableTemp.setFieldList(fieldList);
                JDBCConnectionUtil.free(null, null, columns);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCConnectionUtil.free(conn, null, tables);
        }
        return db;
    }
}
