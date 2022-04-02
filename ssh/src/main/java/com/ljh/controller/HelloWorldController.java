package com.ljh.controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * HelloWorldController
 *
 * @author ljh
 * created on 2022/4/2 11:46
 */
public class HelloWorldController implements Controller {
    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("welcome");
        String result = "hello";
        Map<String, Object> map = new HashMap<>();
        map.put("map1", "A");
        map.put("map2", "B");
        map.put("map3", "C");
        return new ModelAndView("/welcome", "map", map);
    }
}
