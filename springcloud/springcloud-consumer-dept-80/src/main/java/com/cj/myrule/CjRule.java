package com.cj.myrule;


import com.netflix.loadbalancer.IRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CjRule {

    @Bean
    public IRule myrule()
    {
        return new CjRandomRule();
    }


}
