package com.atguigu.gmall.ssoclient.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * 测试单点登录
 */
@Controller
public class HelloController {


    /**
     * 无需登录就可访问
     * @return
     */
    @ResponseBody
    @GetMapping(value = "/hello")
    public String hello() {
        return "hello";
    }


    @GetMapping(value = "/employees")
    public String employees(Model model, HttpSession session, @RequestParam(name = "token", required = false) String token) {
        List<String> emps = new ArrayList<>();
        Object loginUser = session.getAttribute("loginUser");
        if (loginUser == null && token == null) {
            //没登录,跳转到服务器登录
            return "redirect:http://ssoserver.com:8080/login.html?redirect_url=http://client1.com:8081/employees";
        } else {
            emps.add("张三");
            emps.add("李四");
            model.addAttribute("emps",emps);
            return "employees";
        }

    }
}

