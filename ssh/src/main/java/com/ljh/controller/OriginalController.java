package com.ljh.controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * OriginalController
 * 继承 org.springframework.web.servlet.mvc.Controller，一个 Controller 只能写一个方法
 * http://localhost:8080/ori
 *
 * @author ljh
 * created on 2022/4/2 11:46
 */
public class OriginalController implements Controller {
    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("Original");
        Map<String, Object> map = new HashMap<>();
        map.put("A", "1");
        map.put("B", "2");
        map.put("C", "3");
        return new ModelAndView("original", "map", map);
    }
}
