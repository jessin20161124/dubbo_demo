package com.jessin.practice.demo.dubbo_demo.controller;

import com.jessin.practice.demo.dubbo_demo.service.MyFeignClient;
import com.jessin.practice.demo.dubbo_demo.service.SpringClientFactoryTest;
import com.jessin.practice.dubbo.model.UserParam;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: jessin
 * @Date: 2022/1/26 8:59 下午
 */
@RestController
public class FeignController {
    // todo 这里添加注解后启动报错，查看原因
   // @Resource
    private MyFeignClient myFeignClient;

    @Resource
    private SpringClientFactoryTest springClientFactoryTest;

    /**
     * http://localhost:9999/practice/testFeign
     */
    @RequestMapping("/testFeign")
    public String testFeign(UserParam userParam) {
        return myFeignClient.getName();
    }

    /**
     * http://localhost:9999/practice/testGetSubApp
     */
    @RequestMapping("/testGetSubApp")
    public Object testGetSubApp() {
        return springClientFactoryTest.get();
    }

    /**
     * http://localhost:9999/practice/testDestroySubApp
     */
    @RequestMapping("/testDestroySubApp")
    public Object testDestroySubApp() {
        return springClientFactoryTest.destroy();
    }

}
