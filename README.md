
<img src="https://c-arc.oss-cn-beijing.aliyuncs.com/doc/img/carc_gray.png" width="" height="" />

# C-Boot : 基于 SpringBoot 的微服务基础框架

-------

## 项目介绍

C-Boot 是一个针对 Spring Boot 进行二次封装的微服务基础框架。C-Boot 在重新封装一系列基础功能后可作为
基础依赖应用到项目之中。以下是在 Spring Boot 2.1.5 版本基础之上增加功能介绍：

* **API 接口签名验证**
  
    数据接口遵循 RESTful API 设计规范，针对请求，统一进行鉴权认证。当用户向服务器发送用户名和密码（或其他登录凭据），服务器验证通过后，返回用户信息并颁发 token。之后该用户发起的所有请求均携带该 token 与签名信息。服务引入C-Boot之后，自动截取请求信息根据 token 与签名信息进行用户鉴权，确保请求合法。
  
  
* **自定义 HttpMessageConverter**

   针对接口返回值进行格式化统一处理，返回一段统一格式的包含业务数据与附带信息（状态码、分页数据等）的JSON，方便前端统一解析。
   
* **分页查询**

   添加分页查询支持，通过API接口进行分页查询可以指定查询结果分页显示，控制每次返回的数据量。


* **日志处理**
	
	Nacos provides an easy-to-use service dashboard to help you manage your services metadata, configuration, kubernetes DNS, service health and metrics statistics.


## 使用指南
将项目打包上传至Maven仓库，在`pom.xml`文件中直接引用即可。也可在项目中直接引用jar包。

#### Step 1: 打包 C-Boot 项目
使用指定 Maven 配置，进行打包。
```
mvn -s deploy/settings.xml clean 

```

#### Step 2: 引入 C-Boot

在项目中添加C-Boot依赖，在 `Application.class`启动类中继承 C-Boot 所提供的 `BaseApplication.class` 即可。

```

@SpringBootApplication
public class Application extends BaseApplication {

    public static final void main(String[] args) {
    
        SpringApplication.run(Application.class, args);
    }

}
```


## Contact



* 添加作者微信，获取文档等更过项目信息

<img src="https://c-arc.oss-cn-beijing.aliyuncs.com/doc/img/Wechat.png" width="50%" height="50%" />




