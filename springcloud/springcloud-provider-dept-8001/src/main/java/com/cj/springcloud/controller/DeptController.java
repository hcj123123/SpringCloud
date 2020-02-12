package com.cj.springcloud.controller;


import com.cj.springcloud.pojo.Dept;
import com.cj.springcloud.service.DeptService;
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

    @PostMapping("/dept/add")
    public boolean addDept( @RequestBody  Dept dept)
    {
        return deptService.addDept(dept);
    }

    @GetMapping("/dept/get/{id}")
    public Dept queryById(@PathVariable(value = "id") long id)
    {
        return deptService.queryById(id);
    }


    @GetMapping("/dept/list")
    public List<Dept> queryAll()

    {
        System.out.println("1");
        return deptService.queryAll();
    }



    @GetMapping("/dept/discovery")
    public Object discovery()
    {

        List<String> list=client.getServices();
        System.out.println(list);

        List<ServiceInstance> instances = client.getInstances("springcloud-provider-dept");

        for (ServiceInstance instance : instances) {
            System.out.println(instance.getHost());
            System.out.println(instance.getPort());
            System.out.println(instance.getInstanceId());
            System.out.println(instance.getUri());
        }
        return this.client;
    }
}
