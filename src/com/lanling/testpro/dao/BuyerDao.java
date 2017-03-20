package com.lanling.testpro.dao;


import com.lanling.testpro.bean.Buyer;
import com.lanling.testpro.query.BuyerQuery;

import java.util.List;


public interface BuyerDao {

    /**
     * 添加
     *
     * @param buyer
     */
    Integer addBuyer(Buyer buyer);

    /**
     * 根据主键查找
     *
     * @param id
     */
    Buyer getBuyerByKey(String id);

    /**
     * 根据主键批量查找
     *
     * @param idList
     */
    List<Buyer> getBuyersByKeys(List<String> idList);

    /**
     * 根据主键删除
     *
     * @param id
     */
    Integer deleteByKey(String id);

    /**
     * 根据主键批量删除
     *
     * @param idList
     */
    Integer deleteByKeys(List<String> idList);

    /**
     * 根据主键更新
     *
     * @param buyer
     */
    Integer updateBuyerByKey(Buyer buyer);

    /**
     * 分页查询
     *
     * @param buyerQuery
     */
    List<Buyer> getBuyerListWithPage(BuyerQuery buyerQuery);

    /**
     * 集合查询
     *
     * @param buyerQuery
     */
    List<Buyer> getBuyerList(BuyerQuery buyerQuery);

    /**
     * 总条数
     *
     * @param buyerQuery
     */
    int getBuyerListCount(BuyerQuery buyerQuery);
}
