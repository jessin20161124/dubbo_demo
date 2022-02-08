package com.jessin.practice.demo.dubbo_demo.service;

import com.jessin.practice.demo.dubbo_demo.Constants;
import com.jessin.practice.dubbo.service.UserService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.config.spring.ReferenceBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * static / @Component不支持
 * 非static & Configuration时，通过方法获取，父bean已经load class了，增强了。
 *
 * Component可能造成父类过早实例化
 *
 * @Author: jessin
 * @Date: 2022/1/28 9:43 下午
 */
@Configuration
@Profile(Constants.CONSUMER)
public class DubboConsumerBeans {
    @DubboReference(version = "1.0.0", timeout = 2000, registry = "jessinRegistry")
    @Bean
    public ReferenceBean<UserService> userServiceReference() {
        return new ReferenceBean<>();
    }

}
