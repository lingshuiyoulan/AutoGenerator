package com.lanling.generator.database;

import java.util.List;

/**
 * The Class database
 *
 * @author Lanling
 *         on 2017-03-18
 */
public class Database {

    private String name;

    private int type;

    private List<Table> tableList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public List<Table> getTableList() {
        return tableList;
    }

    public void setTableList(List<Table> tableList) {
        this.tableList = tableList;
    }
}
