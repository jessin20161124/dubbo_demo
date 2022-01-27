package com.jessin.practice.demo.dubbo_demo.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: jessin
 * @Date: 2022/1/26 8:57 下午
 */
@FeignClient("name")
public interface MyFeignClient {

    @RequestMapping("/")
    String getName();
}
