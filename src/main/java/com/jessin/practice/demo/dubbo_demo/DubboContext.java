package com.jessin.practice.demo.dubbo_demo;

import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.ProtocolConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @Author: jessin
 * @Date: 19-11-24 下午12:04
 */
@Component
public class DubboContext {

    @Value("${spring.application.name}")
    private String applicationName;
    /**
     * 从zk和对应的group路径获取对应的服务，可以有多个服务，可以复用
     *
     * @param address
     * @param group
     * @return
     */
    @Bean
    public RegistryConfig jessinRegistry(@Value("${dubbo.registry.address}") String address,
            @Value("demo_group") String group) {
        return getRegistryConfig(address, group);
    }

    private RegistryConfig getRegistryConfig(String address, String group) {
        RegistryConfig registryConfig = new RegistryConfig();
        registryConfig.setAddress(address);
        registryConfig.setGroup(group);
        registryConfig.setProtocol("zookeeper");
        return registryConfig;
    }

    /**
     * 必须有对应的applicationConfig
     *
     * @return
     */
    @Bean
    public ApplicationConfig applicationConfig() {
        ApplicationConfig applicationConfig = new ApplicationConfig();
        applicationConfig.setName(applicationName);
        return applicationConfig;
    }

    @Bean
    public ProtocolConfig protocolConfig() {
        // 如果要隔离某个dubbo service，需要开启一个单独的端口，才会起一个单独的线程池
        ProtocolConfig protocolConfig = new ProtocolConfig();
        protocolConfig.setName("dubbo");
        protocolConfig.setCorethreads(200);
        protocolConfig.setThreads(300);
        protocolConfig.setPort(20880);
        protocolConfig.setQueues(1000);
        protocolConfig.setSerialization("hessian2");
        protocolConfig.setThreadpool("cached");
        return protocolConfig;
    }

    //@Bean
    public ProtocolConfig protocolConfig1() {
        //@Service(registry = "jessinRegistry", version = "1.0.0", timeout = 1000, application = "applicationConfig", protocol = "protocolConfig1")
        // 如果要隔离某个dubbo service，需要开启一个单独的端口，才会起一个单独的线程池，
        // 每个dubbo provider必须指定用哪个protocol，否则会注册两个provider invoker，分别为port1和port2
        ProtocolConfig protocolConfig = new ProtocolConfig();
        protocolConfig.setName("dubbo");
        protocolConfig.setCorethreads(30);
        protocolConfig.setThreads(100);
        protocolConfig.setPort(20882);
        protocolConfig.setQueues(1000);
        protocolConfig.setThreadpool("cached");
        return protocolConfig;
    }
}
