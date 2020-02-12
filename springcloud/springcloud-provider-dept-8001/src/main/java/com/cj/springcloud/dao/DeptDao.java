package com.cj.springcloud.dao;


import com.cj.springcloud.pojo.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface DeptDao {


    public boolean addDept(Dept dept);



    public Dept queryById(long id);



    public List<Dept> queryAll();



}
