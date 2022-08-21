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
@DubboService(registry = "jessinRegistry", group = "service_group", version = "1.0.0", timeout = 1000, protocol = {"protocolConfig","protocolConfig1"}, application = "applicationConfig")
public class DomainServiceImpl implements DomainService {

    @Override
    public DomainInfo queryAssociatedDomain(UserParam userParam) {
        DomainInfo domainInfo = new DomainInfo();
        domainInfo.setName(userParam.getName());
        domainInfo.setDesc("域名信息");
        domainInfo.setSourceType(userParam.getId());
        return domainInfo;
    }
}
