package com.ljh.controller;

import com.google.gson.Gson;
import com.ljh.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * UserController
 *
 * @author ljh
 * created on 2022/4/4 13:32
 */
@Controller
@RequestMapping("user")
public class UserController {

    @GetMapping("add")
    public String add() {
        return "user";
    }

    @PostMapping("addByFrom")
    public String addByFrom(User user, HttpServletRequest request) {
        request.setAttribute("user", user);
        return "success";
    }

    @PostMapping("addByJson")
    public void addByJson(User user, HttpServletResponse response) {
        response.setContentType("application/json");
        try (PrintWriter writer = response.getWriter()){
            writer.write(new Gson().toJson(user));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @GetMapping("delete")
    public ModelAndView delete() {
        return new ModelAndView("jsp/user-add", "result", "delete");
    }
}
