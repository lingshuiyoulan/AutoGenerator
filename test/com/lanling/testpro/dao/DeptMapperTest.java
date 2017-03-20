package com.lanling.testpro.dao;

import com.lanling.testpro.bean.Dept;
import com.lanling.testpro.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * The Class: dao test
 *
 * @author: LanLing on 2017-03-18 下午 1:16
 */
public class DeptMapperTest {
    private DeptMapper mapper;
    private SqlSession session;
    @Before
    public void setUp() throws Exception {
        session = MyBatisUtil.getSqlSession();
        mapper = session.getMapper(DeptMapper.class);
    }

    @Test
    public void deleteByPrimaryKey() throws Exception {

    }

    @Test
    public void insert() throws Exception {
        Dept dept = new Dept();
        dept.setDeptno((byte)100);
        dept.setDname("lanling");
        dept.setLoc("hangzhou");
        mapper.insert(dept);
        session.commit();
    }

    @Test
    public void insertSelective() throws Exception {

    }

    @Test
    public void selectByPrimaryKey() throws Exception {
        System.out.println(mapper.selectByPrimaryKey((byte) 100));

        Dept t = session.selectOne("com.lanling.testpro.dao.DeptMapper.selectByPrimaryKey", (byte) 100);
        System.out.println(t);
    }

    @Test
    public void updateByPrimaryKeySelective() throws Exception {
        Dept dept = new Dept();
        dept.setDeptno((byte)100);
        dept.setLoc("zhe hangzhou");
        mapper.updateByPrimaryKeySelective(dept);
        session.commit();
    }

    @Test
    public void updateByPrimaryKey() throws Exception {

    }

}