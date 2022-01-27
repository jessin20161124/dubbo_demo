package com.jessin.practice.demo.dubbo_demo.spi;

import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.common.deploy.ApplicationDeployListener;
import org.apache.dubbo.rpc.model.ApplicationModel;

/**
 * @Author: jessin
 * @Date: 2022/1/27 3:12 下午
 */
@Slf4j
public class MyApplicationDeployListener implements ApplicationDeployListener {

    @Override
    public void onStarting(ApplicationModel scopeModel) {
        log.info("app :{}, onStarting", scopeModel);
    }

    @Override
    public void onStarted(ApplicationModel scopeModel) {
        log.info("app :{}, onStarted", scopeModel);

    }

    @Override
    public void onStopping(ApplicationModel scopeModel) {
        log.info("app :{}, onStopping", scopeModel);

    }

    @Override
    public void onStopped(ApplicationModel scopeModel) {
        log.info("app :{}, onStopped", scopeModel);

    }

    @Override
    public void onFailure(ApplicationModel scopeModel, Throwable cause) {
        log.info("app :{}, onFailure", scopeModel);

    }

    @Override
    public void onModuleStarted(ApplicationModel applicationModel) {
        log.info("app :{}, onModuleStarted", applicationModel);

    }
}
