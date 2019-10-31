package com.ljh.xml.scope.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * SessionController
 *
 * @author ljh
 * created on 2019/10/31 10:02
 */
@Controller
public class SessionController {

    @RequestMapping("testSession")
    @ResponseBody
    public String test() {
        return this.toString();
    }
}
