# 简介

该项目主要利用Spring Boot的自动化配置特性来实现快速的将swagger2引入spring boot应用来生成jersey的API文档，简化原生使用swagger2的整合代码。

# 版本基础

- Spring Boot：1.5.x
- swagger-jersey2-jaxrs：2.7.x
- Jersey 2

# 如何使用

在该项目的帮助下，我们的Spring Boot可以轻松的引入swagger2，主需要做下面两个步骤：

- 在`pom.xml`中引入依赖：

```xml
<dependency>
	<groupId>cn.keets</groupId>
	<artifactId>jersey-starter-swagger</artifactId>
	<version>1.0.0.RELEASE</version>
</dependency>
```

- 在应用主类中增加`@EnableSwagger2Doc`注解

```java
@EnableSwagger2Doc
@SpringBootApplication
public class Bootstrap {

    public static void main(String[] args) {
        SpringApplication.run(Bootstrap.class, args);
    }

}
```

- JerseyConfig 中增加
```java
    @PostConstruct
    public void init() {
        this.register(ApiListingResource.class, SwaggerSerializers.class);
    }
```

默认情况下就能产生所有当前jersey加载的请求映射文档。

# 参数配置

更细致的配置内容参考如下：

## 配置示例

```yaml
swagger:
  enabled: true
  title: spring-boot-starter-swagger
  config-id: demo-mvc
  version: v2
  license: Apache License, Version 2.0
  licenseUrl: https://www.apache.org/licenses/LICENSE-2.0.html
  termsOfServiceUrl: http://git.oschina.net/keets/jersey-starter-swagger
  contact: keets
  base-path: /**
  resource-package: cn.keets.demo

```

## 配置说明

### 默认配置

```
- swagger.enabled=是否开启 // todo 实现线上关闭功能
- swagger.title=标题
- swagger.description=描述
- swagger.version=版本
- swagger.license=许可证
- swagger.licenseUrl=许可证URL
- swagger.termsOfServiceUrl=服务条款URL
- swagger.contact=维护人
- swagger.resource-package=swagger扫描的基础包，默认：全扫描
- swagger.base-path=需要处理的基础URL规则，默认：/**
```
   
   
> swagger ui未包含在项目中，大家可以自己部署静态文件，通过静态文件解析json

如下图所示：
![静态部署](http://ovci9bs39.bkt.clouddn.com/swagger.png)

### 项目地址
github：https://github.com/keets2012/jersey-starter-swagger   
demo git地址：http://git.oschina.net/keets/spring-boot-samples/tree/master/demo-jersey-starter

**你的star是对我最好的鼓励^_^**


### 订阅最新文章，欢迎关注我的公众号

![微信公众号](http://ovci9bs39.bkt.clouddn.com/qrcode_for_gh_ca56415d4966_430.jpg)

---
参考：   
[spring-boot-starter-swagger 1.3.0.RELEASE：新增对JSR-303的支持和host的配置](http://blog.didispace.com/spring-boot-starter-swagger-1.3.0/)




