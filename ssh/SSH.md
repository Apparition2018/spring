# SSH
- SpringMVC + Spring + Hibernate
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
2. spring-servlet.xml 主要配置
    ```xml
    <beans>
        <context:component-scan base-package="com.ljh"/>
        <mvc:annotation-driven/>
        <!-- mvc-view-jsp -->
        <bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
            <property name="prefix" value="/WEB-INF/jsp/"/>
            <property name="suffix" value=".jsp"/>
        </bean>
        <!-- 访问静态资源 -->
        <mvc:resources mapping="/**" location="classpath:static/" cache-period="900"/>
    </beans>
    ```
3. web.xml 配置 CharacterEncodingFilter
    ```xml
    <web-app>
        <filter>
            <filter-name>encodingFilter</filter-name>
            <filter-class>org.springframework.web.filter.CharacterEncodingFilter</filter-class>
            <init-param>
                <param-name>encoding</param-name>
                <param-value>UTF-8</param-value>
            </init-param>
            <init-param>
                <param-name>forceEncoding</param-name>
                <param-value>true</param-value>
            </init-param>
        </filter>
        <filter-mapping>
            <filter-name>encodingFilter</filter-name>
            <url-pattern>/*</url-pattern>
        </filter-mapping>
    </web-app>
    ```
4. spring-servlet.xml 配置 文件上传
    ```xml
    <beans>
        <bean id="multipartResolver" class="org.springframework.web.multipart.commons.CommonsMultipartResolver">
            <property name="defaultEncoding" value="UTF-8"/>
            <property name="maxUploadSize" value="10485760000"/>
            <property name="maxInMemorySize" value="40960"/>
        </bean>
    </beans>
    ```
5. web.xml 配置 ContextLoaderListener 和 <context-param/>
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