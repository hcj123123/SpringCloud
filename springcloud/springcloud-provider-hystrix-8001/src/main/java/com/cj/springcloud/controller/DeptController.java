package com.cj.springcloud.controller;


import com.cj.springcloud.pojo.Dept;
import com.cj.springcloud.service.DeptService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DeptController {

    @Autowired
    private  DeptService deptService;


    @Autowired
    private DiscoveryClient client;

  /*  @PostMapping("/dept/add")
    public boolean addDept( @RequestBody  Dept dept)
    {
        return deptService.addDept(dept);
    }
*/


    @GetMapping("/dept/get/{id}")
    @HystrixCommand(fallbackMethod = "hystrixQueryById")
    public Dept queryById(@PathVariable(value = "id") long id)
    {
        Dept dept = deptService.queryById(id);
        if(dept==null)
        {
            throw new RuntimeException("id=>"+id+"不存在");
        }
        return dept;
    }
    public Dept hystrixQueryById(@PathVariable(value = "id") long id)
    {
       return new Dept().setDeptno(id).setDname("id=>"+id+"不存在").setDb_source("no this database in Mysql");

    }
/*
    @GetMapping("/dept/list")
    public List<Dept> queryAll()

    {
        System.out.println("1");
        return deptService.queryAll();
    }*/



}
