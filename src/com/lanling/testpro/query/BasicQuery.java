package com.lanling.testpro.query;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 条件对象公用对象
 */
public class BasicQuery implements Serializable {

    protected String fields;    //Sql查询字段

    private int pageSize = 20;    //每页数
    private Integer startRow; //起始行
    protected int pageNo = 1;    //页码

    protected List<OrderField> orderFields = new ArrayList<OrderField>();//排序列表字段

    public String getFields() {
        return fields;
    }

    public void setFields(String fields) {
        this.fields = fields;
    }

    public List<OrderField> getOrderFields() {
        return orderFields;
    }

    public void setOrderFields(List<OrderField> orderFields) {
        this.orderFields = orderFields;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
        this.startRow = (pageNo - 1) * this.pageSize;
    }

    public int getPageSize() {
        return pageSize;
    }

    public BasicQuery setPageSize(int pageSize) {
        this.pageSize = pageSize;
        this.startRow = (pageNo - 1) * this.pageSize;
        return this;
    }

    public Integer getStartRow() {
        return startRow;
    }

    public void setStartRow(Integer startRow) {
        this.startRow = startRow;
    }
}
