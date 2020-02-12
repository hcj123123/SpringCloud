package com.cj.springcloud.service;


import com.cj.springcloud.pojo.Dept;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;


@Component
@FeignClient(value = "SPRINGCLOUD-PROVIDER-DEPT",fallbackFactory = DeptClientServiceFallbackFactory.class)
public interface DeptService {



    @PostMapping("/dept/add")
    public boolean addDept(Dept dept);




    @GetMapping("/dept/get/{id}")
    public Dept queryById(@PathVariable(value = "id") long id);



    @GetMapping("/dept/list")
    public List<Dept> queryAll();





}



