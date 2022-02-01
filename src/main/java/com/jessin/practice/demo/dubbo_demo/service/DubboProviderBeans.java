package com.jessin.practice.demo.dubbo_demo.service;

import com.jessin.practice.demo.dubbo_demo.Constants;
import com.jessin.practice.dubbo.service.DomainService;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * @Author: jessin
 * @Date: 2022/2/1 5:26 下午
 */
@Configuration
@Profile(Constants.PROVIDER)
public class DubboProviderBeans {
    @DubboService(registry = "jessinRegistry", group = "service_group", version = "1.0.0", timeout = 1000, application = "applicationConfig")
    @Bean
    public static DomainService domainService () {
        return new DomainServiceImpl();
    }
}
