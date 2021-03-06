## Java Web 发展史
    1. JavaBean + Servlet + JSP
    2. EJB
    3. SpringMVC/Struts + Spring + MyBatis/Hibernate
    4. SpringBoot
    5. Dubbo
    6. SpringCloud
---
## IoC (Inversion of Control - 控制反转)
#### 1. 控制什么? 
        控制对象的创建及销毁（生命周期）
#### 2. 反转什么?
        将对象的控制权交给 IoC 容器
---
## 实例化 Bean
    1. 通过构造方法实例化 Bean
    2. 通过静态方法实例化 Bean
    3. 通过实例方法实例化 Bean
---
## 注入 Bean
    1. 通过构造方法注入 Bean
    2. 通过 setter 方法注入 Bean
    3. 集合类 Bean 的注入
    4. null 值注入
    5. 注入时创建内部 Bean
---
## Bean 作用域
    1. Singleton 作用域
    2. prototype 作用域
    3. Web 环境作用域
        1) request 作用域
        2) session 作用域
        3) application 作用域
        4) websocket 作用域
    5. 自定义作用域 (SimpleThreadScope 作用域)
<table>
    <tr>
        <td align="center" colspan="2" rowspan="2"></td>
        <td align="center" colspan="2">Bean1 作用域</td>
    </tr>
    <tr>
        <td align="center">singleton</td>
        <td align="center">prototype</td>
    </tr>
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

---
## Bean 初始化和销毁
#### 让 Bean 初始化之后 或 销毁之前 执行一些逻辑
    1. 实现 InitializingBean, DisposableBean
    2. xml 配置 init-method 或 destory-method
---
## 注解注入 Bean
    1. 通过方法注入 Bean
        1) 通过构造方法注入 Bean
        2) 通过 setter 方法注入 Bean
    2. 通过属性注入 Bean
    3. 集合类 Bean 的注入
        1) 直接注入集合实例
        2) 将多个泛型的实例注入到集合
            a. 将多个泛型的实例注入到 List
            b. 控制泛型实例在 List 中的顺序
            c. 将多个泛型的实例注入到 Map
    4. String, Integer 等类型直接赋值
    5. SpringIoC 容器内置接口实例注入
---
## 注解 Bean 初始化和销毁
#### 让 Bean 初始化之后 或 销毁之前 执行一些逻辑
    1. 实现 InitializingBean, DisposableBean
    2. @PostConstruct, @PreDestroy
    3. @Configuration 文件中 @Bean(initMethod = "xxx", destroyMethod = "xxx")
---
## SpringWeb 上下文环境
1. 如果使用 DispatcherServlet，则不需要增加其他任何配置
```
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
```
2. 如果不适用 DispatcherServlet，那么需要增加 listener 或 filter
    1. 如果是 Servlet 2.4 以上
    ```
    <listener>
        <listener-class>
            org.springframework.web.context.request.RequestContextListener
        </listener-class>
    </listener>
    ```
    2. 如果是 Servlet 2.4 及以下
    ```
    <filter>
        <filter-name>requestContextFilter</filter-name>
        <filter-class>org.springframework.web.filter.RequestContextFilter</filter-class>
    </filter>
    <filter-mapping>
        <filter-name>requestContextFilter</filter-name>
        <url-pattern>/*</url-pattern>
    </filter-mapping>
    ```
---