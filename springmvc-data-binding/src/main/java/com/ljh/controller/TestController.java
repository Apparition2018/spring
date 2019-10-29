package com.ljh.controller;

import com.ljh.object.*;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * TestController
 *
 * @author ljh
 * created on 2019/10/28 16:25
 */
@Controller
public class TestController {

    // http://localhost:8080/baseType.do?age=10
    @RequestMapping(value = "baseType.do")
    @ResponseBody
    public String baseType(@RequestParam("age") int age) {
        return "age:" + age;
    }

    // http://localhost:8080/baseType2.do?age=10
    @RequestMapping(value = "baseType2.do")
    @ResponseBody
    public String baseType2(Integer age) {
        return "age:" + age;
    }

    // http://localhost:8080/array.do?names=Tom&names=Lucy&names=Jim
    @RequestMapping(value = "array.do")
    @ResponseBody
    public String array(String[] names) {
        StringBuilder sb = new StringBuilder();
        for (String name : names) {
            sb.append(name).append(" ");
        }
        return sb.toString();
    }

    // http://localhost:8080/object.do?name=Tom&age=10
    // http://localhost:8080/object.do?name=Tom&age=10&contactInfo.phone=10086
    // http://localhost:8080/object.do?user.name=Tom&admin.name=Lucy&age=10
    @RequestMapping(value = "object.do")
    @ResponseBody
    public String object(User user, Admin admin) {
        return user.toString() + " " + admin.toString();
    }

    @InitBinder("user")
    public void initUser(WebDataBinder binder) {
        binder.setFieldDefaultPrefix("user.");
    }

    @InitBinder("admin")
    public void initAdmin(WebDataBinder binder) {
        binder.setFieldDefaultPrefix("admin.");
    }

    // http://localhost:8080/list.do?users[0].name=Tom&users[1].name=Lucy
    // http://localhost:8080/list.do?users[0].name=Tom&users[1].name=Lucy&users[20].name=Jim
    @RequestMapping(value = "list.do")
    @ResponseBody
    public String list(UserListForm userListForm) {
        return "listSize:" + userListForm.getUsers().size() + " " + userListForm.toString();
    }

    // http://localhost:8080/set.do?users[0].name=Tom&users[1].name=Lucy
    // http://localhost:8080/set.do?users[0].name=Tom&users[1].name=Tom
    @RequestMapping(value = "set.do")
    @ResponseBody
    public String set(UserSetForm userSetForm) {
        return userSetForm.toString();
    }

    // http://localhost:8080/map.do?users['x'].name=Tom&users['x'].age=10&users['y'].name=Lucy
    @RequestMapping(value = "map.do")
    @ResponseBody

    public String map(UserMapForm userMapForm) {
        return userMapForm.toString();
    }

    // localhost:8080/json.do
    // application/json
    //  {
    //      "name": "Jim",
    //      "age": 16,
    //      "contactInfo": {
    //            "address": "beijing",
    //            "phone": "10010"
    //      }
    //  }
    @RequestMapping(value = "json.do")
    @ResponseBody
    public String json(@RequestBody User user) {
        return user.toString();
    }

    // localhost:8080/xml.do
    // application/xml
    //  <?xml version="1.0" encoding="UTF-8" ?>
    //      <admin>
    // 	    <name>Jim</name>
    // 	    <age>16</age>
    //  </admin>
    @RequestMapping(value = "xml.do")
    @ResponseBody
    public String xml(@RequestBody Admin admin) {
        return admin.toString();
    }

    // http://localhost:8080/converter.do?bool=1
    // http://localhost:8080/converter.do?bool=on
    // http://localhost:8080/converter.do?bool=yes
    @RequestMapping(value = "converter.do")
    @ResponseBody
    public String converter(Boolean bool) {
        return bool.toString();
    }

    // http://localhost:8080/date.do?date=2018-01-01
    @RequestMapping(value = "date.do")
    @ResponseBody
    public String date(Date date) {
        return date.toString();
    }

    @InitBinder("date")
    public void initDate(WebDataBinder binder) {
        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
    }

    // http://localhost:8080/book
    @RequestMapping(value = "book", method = RequestMethod.GET)
    @ResponseBody
    public String book(HttpServletRequest request) {
        String contentType = request.getContentType();
        if (contentType == null) {
            return "book.default";
        } else if (contentType.equals("txt")) {
            return "book.txt";
        } else if (contentType.equals("html")) {
            return "book.html";
        }
        return "book.default";
    }

    @RequestMapping(value = "subject/{subjectId}", method = RequestMethod.GET)
    @ResponseBody
    public String subjectGet(@PathVariable("subjectId") String subjectId) {
        return "this is a get method, subjectId: " + subjectId;
    }

    @RequestMapping(value = "subject/{subjectId}", method = RequestMethod.POST)
    @ResponseBody
    public String subjectPost(@PathVariable("subjectId") String subjectId) {
        return "this is a post method, subjectId: " + subjectId;
    }

    @RequestMapping(value = "subject/{subjectId}", method = RequestMethod.PUT)
    @ResponseBody
    public String subjectPut(@PathVariable("subjectId") String subjectId) {
        return "this is a put method, subjectId: " + subjectId;
    }

    @RequestMapping(value = "subject/{subjectId}", method = RequestMethod.DELETE)
    @ResponseBody
    public String subjectDelete(@PathVariable("subjectId") String subjectId) {
        return "this is a delete method, subjectId: " + subjectId;
    }

}
