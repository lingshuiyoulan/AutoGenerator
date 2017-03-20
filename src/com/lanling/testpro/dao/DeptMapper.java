package com.lanling.testpro.dao;

import com.lanling.testpro.bean.Dept;

public interface DeptMapper {
    int deleteByPrimaryKey(Byte deptno);

    int insert(Dept record);

    int insertSelective(Dept record);

    Dept selectByPrimaryKey(Byte deptno);

    int updateByPrimaryKeySelective(Dept record);

    int updateByPrimaryKey(Dept record);
}