#【精品锦集】Java热门回答08
1. 在微服务的架构中，一个业务涉及到调用多个其他微服务，如何保证多个微服务间的事务一致性？
分布式架构下的事务一致性可以考虑用2PC或者Try Confirm Cancel模式实现.
微服务的数据一致性问题，目前的解决方案是
1、使用TCC方式，或者Saga方式，达到最终一致性
2、阿里巴巴开源的Fescar框架可以考虑一下。
微服务如果使用http协议的REST API 由于其协议的根本特性，所以没有办法，为了性能，放弃了强一致性。

