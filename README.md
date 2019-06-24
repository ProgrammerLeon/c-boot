
<img src="/doc/Wechat.png" width="50%" height="50%" />

# C-Boot: C-ARC 架构基础项目

-------

## 项目介绍

C-Boot 是一个针对 Spring Boot 进行二次封装的基础项目。C-Boot 在重新封装一系列基础功能后可作为
基础依赖应用到项目之中。以下是在 Spring Boot 2.1.5 版本基础之上增加功能介绍：

* **Service Discovery and Service Health Check** 
    
    Nacos makes it simple for services to register themselves and to discover other services via a DNS or HTTP interface. Nacos also provides real-time healthchecks of services to prevent sending requests to unhealthy hosts or service instance.

* **Dynamic Configuration Management**
  
  Dynamic Configuration Service allows you to manage configurations of all services in a centralized and dynamic manner across all environments. Nacos eliminates the need to redeploy applications and services when configurations are updated，which makes configuration changes more efficient and agile.

* **Dynamic DNS Service**

   Nacos supports weighted routing, making it easier for you to implement mid-tier load balancing, flexible routing policies, flow control, and simple DNS resolution services in the production environment within your data center. It helps you to implement DNS-based service discovery easily and prevent applications from coupling to vendor-specific service discovery APIs.

* **Service and MetaData Management**
	
	Nacos provides an easy-to-use service dashboard to help you manage your services metadata, configuration, kubernetes DNS, service health and metrics statistics.
 

## Quick Start
It is super easy to get started with your first project.

#### Step 1: Download the binary package 

You can download the package from the  [latest stable release](https://github.com/alibaba/nacos/releases).  

Take release nacos-server-0.9.0.zip for example.
```
unzip nacos-server-0.9.0.zip
cd nacos/bin 
``` 

#### Step 2: Start Server

On the **Linux/Unix/Mac** platform, run the following command to start server with standalone mode: 
```
sh startup.sh -m standalone
```

On the **Windows** platform, run the following command to start server with standalone mode.  Alternatively, you can also double-click the startup.cmd to run NacosServer.
```
cmd startup.cmd -m standalone
```

For more details, see [quick-start.](https://nacos.io/en-us/docs/quick-start.html)

## Quick start for other open-source projects:
* [Quick start with Nacos command and console](https://nacos.io/en-us/docs/quick-start.html)

* [Quick start with dubbo](https://nacos.io/en-us/docs/use-nacos-with-dubbo.html)

* [Quick start with spring cloud](https://nacos.io/en-us/docs/quick-start-spring-cloud.html)

* [Quick start with kubernetes](https://nacos.io/en-us/docs/use-nacos-with-kubernetes.html)


## Documentation

You can view the full documentation from the [Nacos website](https://nacos.io/en-us/docs/what-is-nacos.html).

All the latest and long-term notice can also be found here from [Github notice issue](https://github.com/alibaba/nacos/labels/notice)


## Contributing

Contributors are welcomed to join Nacos project. Please check [CONTRIBUTING](./CONTRIBUTING.md) about how to contribute to this project.

## Other Related Project Repositories

* [nacos-spring-project](https://github.com/nacos-group/nacos-spring-project) provides the integration functionality for Spring.
* [nacos-group](https://github.com/nacos-group) is the reposity that hosts the eco tools for Nacos, such as SDK, synchronization tool, etc.
* [spring-cloud-alibaba](https://github.com/spring-cloud-incubator/spring-cloud-alibaba) provides the one-stop solution for application development over Alibaba middleware which includes Nacos.

## Contact

* [Gitter](https://gitter.im/alibaba/nacos): Nacos's IM tool for community messaging, collaboration and discovery.
* [Twitter](https://twitter.com/nacos2): Follow along for latest nacos news on Twitter.
* [Weibo](https://weibo.com/u/6574374908): Follow along for latest nacos news on Weibo (Twitter of China version).
* [Nacos Segmentfault](https://segmentfault.com/t/nacos): Get latest notice and prompt help from Segmentfault.
* Email Group:
     * users-nacos@googlegroups.com: Nacos usage general discussion.
     * dev-nacos@googlegroups.com: Nacos developer discussion (APIs, feature design, etc).
     * commits-nacos@googlegroups.com: Commits notice, very high frequency.
* Join us from DingDing. 

<img src="doc/Wechat.png" width="50%" height="50%" />

## Who is using

These are only part of the companies using Nacos, for reference only. If you are using Nacos, please [add your company here](https://github.com/alibaba/nacos/issues/273) to tell us your scenario to make Nacos better.



