package com.jessin.practice.demo.dubbo_demo.service;

import com.netflix.loadbalancer.ILoadBalancer;
import javax.annotation.Resource;
import org.springframework.cloud.netflix.ribbon.SpringClientFactory;
import org.springframework.stereotype.Component;

/**
 * @Author: jessin
 * @Date: 2022/1/27 3:41 下午
 */
@Component
public class SpringClientFactoryTest {

    @Resource
    private SpringClientFactory springClientFactory;

    public String get() {
        ILoadBalancer iLoadBalancer = springClientFactory.getLoadBalancer("name");
        return "iLoadBalancer";
    }
    public String destroy() {
        springClientFactory.destroy();
        return "success";
    }
}
