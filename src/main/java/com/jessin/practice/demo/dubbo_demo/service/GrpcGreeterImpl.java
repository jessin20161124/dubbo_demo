package com.jessin.practice.demo.dubbo_demo.service;

import com.jessin.practice.demo.dubbo_demo.Constants;
import com.jessin.practice.demo.dubbo_demo.hello.DubboGreeterGrpc;
import com.jessin.practice.demo.dubbo_demo.hello.HelloReply;
import com.jessin.practice.demo.dubbo_demo.hello.HelloRequest;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.context.annotation.Profile;


// 定义实现类，注意这里的 DubboGreeterGrpc.GreeterImplBase 是基于 proto文件 自动生成的

/**
 * 注意，grpc必须指定接口
 * 应用级别的发现在多协议时有问题。
 * 用了grpc后，除了Greeter可以外，其他的都不行，会出现client dubbo协议调用服务端grpc协议的情况。端口跟协议不绑定了
 * netty版本啥的也要对应
 */
// https://github.com/apache/dubbo-samples/blob/master/dubbo-samples-grpc/dubbo-samples-original/pom.xml
@Slf4j
@Profile(Constants.PROVIDER)
@DubboService(registry = "jessinRegistry", group = "service_group", version = "1.0.0", timeout = 1000, interfaceClass = DubboGreeterGrpc.IGreeter.class, protocol = "protocolConfigGrpc", application = "applicationConfig")
public class GrpcGreeterImpl extends DubboGreeterGrpc.GreeterImplBase {

    @Override
    public void sayHello(HelloRequest request, StreamObserver<HelloReply> responseObserver) {
        log.info("Executing thread is " + Thread.currentThread().getName());
        HelloReply reply = HelloReply.newBuilder().setMessage("Hello " + request.getName()).build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }


}