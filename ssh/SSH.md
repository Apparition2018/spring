# [SSH](https://www.bilibili.com/video/BV1qb411L7RS)
- SpringMVC + Spring + Hibernate
---
## SpringMVC
1. [web.xml](src/main/webapp/WEB-INF/web.xml)
2. [spring-servlet.xml](src/main/resources/spring-servlet.xml)
3. web.xml 配置 ContextLoaderListener 和 <context-param/>
```xml
<beans>
    <context-param>
        <param-name>contextConfigLocation</param-name>
        <param-value>classpath:applicationContext.xml</param-value>
    </context-param>
    <listener>
        <listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
    </listener>
</beans>
```
---
## 获取 WebApplicationContext
1. applicationContext.xml：`WebApplicationContextUtils.getRequiredWebApplicationContext(request.getSession().getServletContext());`
2. spring-servlet.xml：`RequestContextUtils.findWebApplicationContext(request);`
---
