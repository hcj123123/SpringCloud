package com.cj.springcloud.service;


import com.cj.springcloud.pojo.Dept;

import java.util.List;

public interface DeptService {


    public boolean addDept(Dept dept);



    public Dept queryById(long id);



    public List<Dept> queryAll();


}
