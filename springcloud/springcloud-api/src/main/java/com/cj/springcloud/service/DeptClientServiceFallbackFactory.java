package com.cj.springcloud.service;

import com.cj.springcloud.pojo.Dept;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class DeptClientServiceFallbackFactory implements FallbackFactory {
    @Override
    public DeptService create(Throwable throwable) {
        return new DeptService() {
            @Override
            public boolean addDept(Dept dept) {
                return false;
            }

            @Override
            public Dept queryById(long id) {
                return new Dept().setDeptno(id).setDname("id=>"+id+"降级，已被关闭").setDb_source("no this database in Mysql");
            }

            @Override
            public List<Dept> queryAll() {
                return null;
            }
        };
    }
}
