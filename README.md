# SpringCloud

0212-服务离线

（1）服务下架

将注册到Eureka Server中的Eureka Client从server的注册表中移除
，这样其他Client就无法发现该Client了。

eg:

添加actuator监控：开启所有监控终端
management.endpoints.web.exposure.include=*

开启shutdown监控终端
management.endpoint.shutdown.enabled=true

测试：POST：localhost:8081/actuator/shutdown

（2）服务下线(平滑上下线)

Client并没有从Eureka Server的注册表中移除，其他Client还可以发现该服务
，而是通过修改服务的状态来达到其他Client无法调用的目的

eg:

测试：POST:localhost:8081/actuator/service-registry

{   
  "status":"DOWN"
}

4.5 Hystrix高级属性设置

4.5.1 执行隔离策略

执行隔离策略有两大作用：防止服务熔断、防止服务雪崩。

服务熔断：高并发情况下，如果说某一个模块出现了响应时间逐渐开始边长，已经出问题了，
但是又有大量的请求过来了，那么这些请求一到，可能使该模块挂掉，停止响应，发生熔断。

服务雪崩：某一个提供者已经发生熔断，消费者对提供者的请求，到了消费者以后直接返回消费者的
降级结果；但是在发生熔断之前，消费者并不是马上返回降级结果的，而是等待请求生产者超时，在
高并发情况下，出现大量请求被阻塞等待响应结果，有可能就会引发服务雪崩。


