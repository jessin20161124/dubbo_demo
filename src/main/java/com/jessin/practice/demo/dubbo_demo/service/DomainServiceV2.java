package com.jessin.practice.demo.dubbo_demo.service;

import com.jessin.practice.demo.dubbo_demo.Constants;
import com.jessin.practice.dubbo.model.DomainInfo;
import com.jessin.practice.dubbo.model.UserParam;
import com.jessin.practice.dubbo.service.DomainService;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.context.annotation.Profile;

/**
 * @Author: jessin
 * @Date: 2022/1/10 10:30 上午
 */
@Profile(Constants.PROVIDER)
@DubboService(registry = "jessinRegistry", version = "1.0.2", timeout = 1000, application = "applicationConfig")
public class DomainServiceV2 implements DomainService {
    @Override
    public DomainInfo queryAssociatedDomain(UserParam userParam) {
        DomainInfo domainInfo = new DomainInfo();
        domainInfo.setName(userParam.getName());
        domainInfo.setDesc("域名信息v2");
        domainInfo.setSourceType(userParam.getId());
        long sleepMillis = 30 * 60 * 1000;
        try {
            Thread.sleep(sleepMillis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return domainInfo;
    }
}
