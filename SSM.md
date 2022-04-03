# SSM
- Spring + SpringMVC + Hibernate
---
## Reference
- [SpringMVC+hibernate+spring实践_哔哩哔哩](https://www.bilibili.com/video/BV1qb411L7RS)
---
## 创建项目
- 创建项目时，Create from archetype 选择 maven-archetype-webapp
---
## SpringMVC
1. web.xml 配置 DispatcherServlet
    ```xml
    <web-app>
        <servlet>
            <servlet-name>spring-mvc</servlet-name>
            <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
            <init-param>
                <param-name>contextConfigLocation</param-name>
                <param-value>classpath:spring-servlet.xml</param-value>
            </init-param>
            <load-on-startup>1</load-on-startup>
        </servlet>
        <servlet-mapping>
            <servlet-name>spring-mvc</servlet-name>
            <url-pattern>/</url-pattern>
        </servlet-mapping>
    </web-app>
    ```
2. spring-servlet.xml 配置 mvc-view-jsp
    ```xml
    <bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
        <property name="prefix" value="/"/>
        <property name="suffix" value=".jsp"/>
    </bean>
    ```
3. spring-servlet.xml 配置 访问静态资源
    ```xml
    <mvc:resources mapping="/**" location="classpath:static/" cache-period="900"/>
    ```