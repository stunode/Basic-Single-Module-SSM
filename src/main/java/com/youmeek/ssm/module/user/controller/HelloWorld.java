package com.youmeek.ssm.module.user.controller;

import com.youmeek.ssm.module.user.entities.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@RequestMapping("/Basic-Single-Module-SSM")
@Controller
public class HelloWorld {
    private static final String SUCCESS = "success";
    @RequestMapping("/testPojo")
    public String testPojo(User user) {
        System.out.println("testPojo: " + user);
        return SUCCESS;
    }

    /**
     * 1. 使用 @RequestMapping 注解来映射请求的 URL
     * 2. 返回值会通过视图解析器解析为实际的物理视图, 对于 InternalResourceViewResolver 视图解析器, 会做如下的解析:
     * 通过 prefix + returnVal + 后缀 这样的方式得到实际的物理视图, 然会做转发操作
     *
     * /WEB-INF/views/success.jsp
     *
     * @return
     */
    @RequestMapping("/helloworld")
    public String hello(){
        System.out.println("hello world");
        return "success";
    }

}
