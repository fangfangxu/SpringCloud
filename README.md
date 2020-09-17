# SpringCloud

0212-服务离线

（1）服务下架

将注册到Eureka Server中的Eureka Client从server的注册表中移除
，这样其他Client就无法发现该Client了。

（2）服务下线

Client并没有从Eureka Server的注册表中移除，其他Client还可以发现该服务
，而是通过修改服务的状态来达到其他Client无法调用的目的