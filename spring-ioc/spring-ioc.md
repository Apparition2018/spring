## Java Web 发展史
1. JavaBean + Servlet + JSP
2. EJB
3. SpringMVC/Struts + Spring + MyBatis/Hibernate
4. SpringBoot
5. Dubbo
6. SpringCloud
---
## IoC (Inversion of Control - 控制反转)
1. 控制：控制对象的创建及销毁（生命周期）
2. 反转：将对象的控制权交给 IoC 容器
---
## XML
### [实例化 Bean](./src/test/java/com/ljh/xml/InstantiateTest.java)
1. 无参构造方法
2. 工厂方法
    1. 静态工厂方法
    2. 实例工厂方法
3. FactoryBean
### [注入 Bean](./src/test/java/com/ljh/xml/InjectionTest.java)
1. 构造方法注入
    - c 命名空间注入：快捷的构造方法注入
2. setter 注入
    - p 命名空间注入：快捷的 setter 注入
- 参数注入
    1. 注入集合 List / Set / Map / Properties
    2. 注入 null 值
### [Bean 作用域](./src/test/java/com/ljh/xml/ScopeTest.java)
1. Singleton
2. prototype
3. Web-aware
    1. request
    2. session
    3. application
    4. websocket
4. 自定义作用域 (SimpleThreadScope 作用域)
<table>
    <tr>
        <td align="center" colspan="2" rowspan="2"></td>
        <td align="center" colspan="2">Bean1 作用域</td>
    </tr>
    <tr>无参构造器
    <tr>
        <td align="center"  rowspan="2">Bean2 作用域</td>
        <td align="center">singleton</td>
        <td align="center">Bean1 单实例<br/>Bean2 单实例</td>
        <td align="center">Bean1 多实例<br/>Bean2 单实例</td>
    </tr>
    <tr>
        <td align="center">prototype</td>
        <td align="center">Bean1 单实例<br/>Bean2 多实例</td>
        <td align="center">Bean1 单实例<br/>Bean2 多实例</td>
    </tr>
</table>

### [Bean 初始化和销毁](./src/test/java/com/ljh/xml/InitDestroyTest.java)
- 初始化回调
    - implements InitializingBean
    - `<bean init-method/>`
- 销毁回调
    - implements DisposableBean
    - `<bean destroy-method/>`
- 全局初始化和销毁方法：`<beans default-init-method default-destroy-method/>`
---
## 注解
### [注入 Bean](./src/test/java/com/ljh/annotation/InjectionTest.java)
1. 方法注入
    1. 构造方法注入
    2. setter 注入
2. 属性注入
3. 集合类 Bean 的注入
    1. 直接注入集合实例
    2. 将多个泛型的实例注入到集合
        1. 将多个泛型的实例注入到 List
        2. 控制泛型实例在 List 中的顺序
        3. 将多个泛型的实例注入到 Map
4. String, Integer 等类型直接赋值
5. SpringIoC 容器内置接口实例注入
### [Bean 初始化和销毁](./src/test/java/com/ljh/annotation/InitDestroyTest.java)
- 让 Bean 初始化之后 或 销毁之前 执行一些逻辑
    1. 实现 InitializingBean, DisposableBean
    2. @PostConstruct, @PreDestroy
    3. @Configuration 文件中 @Bean(initMethod = "xxx", destroyMethod = "xxx")
---
## SpringWeb 上下文环境
1. 如果使用 DispatcherServlet，则不需要增加其他任何配置
```xml
<web-app>
    <servlet>
        <servlet-name>SpringServlet</servlet-name>
        <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
        <init-param>
            <param-name>contextConfigLocation</param-name>
            <param-value>classpath:spring.xml</param-value>
        </init-param>
    </servlet>
    <servlet-mapping>
        <servlet-name>SpringServlet</servlet-name>
        <url-pattern>/*</url-pattern>
    </servlet-mapping>
</web-app>
```
2. 如果不适用 DispatcherServlet，那么需要增加 listener 或 filter
    1. 如果是 Servlet 2.4 以上
    ```xml
    <web-app>
        <listener>
            <listener-class>
                org.springframework.web.context.request.RequestContextListener
            </listener-class>
        </listener>
    </web-app>
    ```
    2. 如果是 Servlet 2.4 及以下
    ```xml
    <web-app>
        <filter>
            <filter-name>requestContextFilter</filter-name>
            <filter-class>org.springframework.web.filter.RequestContextFilter</filter-class>
        </filter>
        <filter-mapping>
            <filter-name>requestContextFilter</filter-name>
            <url-pattern>/*</url-pattern>
        </filter-mapping>
    </web-app>
    ```
---
