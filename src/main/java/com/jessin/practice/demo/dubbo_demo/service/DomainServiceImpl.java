package com.jessin.practice.demo.dubbo_demo.service;

import com.jessin.practice.dubbo.model.DomainInfo;
import com.jessin.practice.dubbo.model.UserParam;
import com.jessin.practice.dubbo.service.DomainService;

/**
 * @Author: jessin
 * @Date: 2022/1/10 10:30 上午
 */
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
