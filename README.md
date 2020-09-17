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