# SSM
- Spring + SpringMVC + Hibernate
---
## Reference
- [SpringMVC+hibernate+springʵ��_��������](https://www.bilibili.com/video/BV1qb411L7RS)
---
## ������Ŀ
- ������Ŀʱ��Create from archetype ѡ�� maven-archetype-webapp
---
## SpringMVC
1. web.xml
    ```
    <servlet>
        <servlet-name>spring-mvc</servlet-name>
        <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
        <init-param>
            <param-name>contextConfigLocation</param-name>
            <param-value>classpath*:spring-servlet.xml</param-value>
        </init-param>
        <load-on-startup>1</load-on-startup>
    </servlet>
    <servlet-mapping>
        <servlet-name>spring-mvc</servlet-name>
        <url-pattern>/</url-pattern>
    </servlet-mapping>
    ```
2. spring-servlet.xml ���� ViewResolver
    ```
    <bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
        <property name="prefix" value="/"/>
        <property name="suffix" value=".jsp"/>
    </bean>
    ```