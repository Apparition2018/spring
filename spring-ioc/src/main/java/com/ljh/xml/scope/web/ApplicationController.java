package com.ljh.xml.scope.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * ApplicationController
 *
 * @author ljh
 * created on 2019/10/31 10:03
 */
@Controller
public class ApplicationController {

    @RequestMapping("testApplication")
    @ResponseBody
    public String test() {
        return this.toString();
    }
}
