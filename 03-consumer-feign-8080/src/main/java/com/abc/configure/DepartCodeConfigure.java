package com.abc.configure;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;

@Controller
public class DepartCodeConfigure {
     
    //修改负载均衡策略为随机策略
    @Bean
    public IRule loadBanlanceRule(){
        return new RoundRobinRule();
    }

}
