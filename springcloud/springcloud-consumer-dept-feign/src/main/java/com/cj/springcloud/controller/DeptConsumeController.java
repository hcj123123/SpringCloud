package com.cj.springcloud.controller;


import com.cj.springcloud.pojo.Dept;
import com.cj.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class DeptConsumeController {



    @Autowired
    private DeptService deptService;

    @RequestMapping("/consumer/dept/get/{id}")
    public Dept get(@PathVariable("id")Long id)
    {

        return this.deptService.queryById(id);
    }

    @RequestMapping("/consumer/dept/add")
    public boolean addDept(Dept dept)
    {
        return this.deptService.addDept(dept);
    }


    @RequestMapping("/consumer/dept/list")
    public List<Dept> queryAll()
    {
        return this.deptService.queryAll();

    }

}
