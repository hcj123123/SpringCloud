package com.cj.springcloud.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigClientController {



    @Value("${spring.application.name}")
    private String applicationName;


    @Value("${eureka.client.service-url.defaultZone}")
    private  String port;


    @Value("${server.port}")
    private String eurekaServer;






    @RequestMapping("/config")
    public  String getConfig(){
        return "ConfigClientController{" +
                "applicationName='" + applicationName + '\'' +
                ", port='" + port + '\'' +
                ", eurekaServer='" + eurekaServer + '\'' +
                '}';
    }
}
