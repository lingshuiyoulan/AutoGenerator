package com.lanling.testpro.dao;

import com.lanling.testpro.bean.Buyer;
import com.lanling.testpro.query.BuyerQuery;
import com.lanling.testpro.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author Lanling
 *
 */
public class BuyerDaoTest {
    private BuyerDao buyerDao;
    private SqlSession session;

    @Before
    public void setUp() throws Exception {
        session = MyBatisUtil.getSqlSession();
        buyerDao = session.getMapper(BuyerDao.class);
    }

    @Test
    public void addBuyer() throws Exception {

    }

    @Test
    public void getBuyerByKey() throws Exception {
        System.out.println(buyerDao.getBuyerByKey("a"));
    }

    @Test
    public void getBuyersByKeys() throws Exception {

    }

    @Test
    public void deleteByKey() throws Exception {

    }

    @Test
    public void deleteByKeys() throws Exception {

    }

    @Test
    public void updateBuyerByKey() throws Exception {

    }

    @Test
    public void getBuyerListWithPage() throws Exception {

    }

    @Test
    public void getBuyerList() throws Exception {
        BuyerQuery query = new BuyerQuery();
        query.setFields("username,password,email");
        query.orderbyPassword(true);
        query.orderbyUsername(false);

        List<Buyer> buyers = buyerDao.getBuyerList(query);
        for (Buyer b : buyers) {
            System.out.println(b);
        }
    }

    @Test
    public void getBuyerListCount() throws Exception {

    }

}