package com.ljh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Objects;

/**
 * ContextController
 *
 * @author ljh
 * created on 2022/4/5 15:03
 */
@Controller
@RequestMapping("context")
public class ContextController {

    @GetMapping("get")
    public String get(HttpServletRequest request) {
        // configLocations: applicationContext.xml
        ServletContext servletContext = request.getSession().getServletContext();
        WebApplicationContext ac1 = WebApplicationContextUtils.getRequiredWebApplicationContext(servletContext);
        System.out.println(Objects.requireNonNull(ac1).getDisplayName());   // Root WebApplicationContext
        System.out.println(Arrays.toString(ac1.getBeanDefinitionNames()));  // []

        // configLocations: spring-servlet.xml
        WebApplicationContext ac2 = RequestContextUtils.findWebApplicationContext(request);
        System.out.println(Objects.requireNonNull(ac2).getDisplayName());   // WebApplicationContext for namespace 'spring-mvc-servlet'
        System.out.println(Arrays.toString(ac2.getBeanDefinitionNames()));  // [/ori, contextController, uploadController, userController, org.springframework.context.annotation.internalConfigurationAnnotationProcessor, org.springframework.context.annotation.internalAutowiredAnnotationProcessor, org.springframework.context.annotation.internalCommonAnnotationProcessor, org.springframework.context.event.internalEventListenerProcessor, org.springframework.context.event.internalEventListenerFactory, mvcContentNegotiationManager, org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping, mvcCorsConfigurations, org.springframework.format.support.FormattingConversionServiceFactoryBean#0, org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter, mvcUriComponentsContributor, org.springframework.web.servlet.handler.MappedInterceptor#0, org.springframework.web.servlet.mvc.method.annotation.ExceptionHandlerExceptionResolver#0, org.springframework.web.servlet.mvc.annotation.ResponseStatusExceptionResolver#0, org.springframework.web.servlet.mvc.support.DefaultHandlerExceptionResolver#0, org.springframework.web.servlet.handler.BeanNameUrlHandlerMapping, org.springframework.web.servlet.mvc.HttpRequestHandlerAdapter, org.springframework.web.servlet.mvc.SimpleControllerHandlerAdapter, mvcHandlerMappingIntrospector, localeResolver, themeResolver, viewNameTranslator, flashMapManager, org.springframework.web.servlet.view.InternalResourceViewResolver#0, mvcResourceUrlProvider, org.springframework.web.servlet.handler.MappedInterceptor#1, mvcPathMatcher, mvcUrlPathHelper, org.springframework.web.servlet.resource.ResourceHttpRequestHandler#0, org.springframework.web.servlet.handler.SimpleUrlHandlerMapping#0, multipartResolver]

        return "success";
    }
}
