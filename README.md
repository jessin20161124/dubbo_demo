## <center> dubbo 3.0 spring boot demo </center>

#### 部署api到本地仓库
&nbsp;&nbsp;&nbsp;&nbsp;部署api到本地仓库：[https://github.com/jessin20161124/api](https://github.com/jessin20161124/api)

#### 启动provider
&nbsp;&nbsp;&nbsp;&nbsp;本地：
```
  java -Dspring.profiles.active=provider -Dserver.port=8081 -jar target/dubbo_demo-0.0.1-SNAPSHOT.jar
```
&nbsp;&nbsp;&nbsp;&nbsp;公网云服务器：
```
  java -DDUBBO_IP_TO_BIND=101.43.195.208 -Dspring.profiles.active=provider -Dserver.port=8081 -jar target/dubbo_demo-0.0.1-SNAPSHOT.jar
```


#### 启动consumer
```
 java -Dspring.profiles.active=consumer -Dserver.port=8082 -jar target/dubbo_demo-0.0.1-SNAPSHOT.jar
```


### 更多精彩样例，请关注公众号：
![扫一扫](https://img-blog.csdnimg.cn/e021faa547534e0080356b65d995b6f8.png?x-oss-process=image/watermark,type_ZHJvaWRzYW5zZmFsbGJhY2s,shadow_50,text_Q1NETiBAYWNfZGFvX2Rp,size_20,color_FFFFFF,t_70,g_se,x_16#pic_center)


