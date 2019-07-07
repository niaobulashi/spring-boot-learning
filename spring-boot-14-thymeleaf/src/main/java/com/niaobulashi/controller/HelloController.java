package com.niaobulashi.controller;

import com.niaobulashi.exception.MyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

    @RequestMapping("/")
    public String index(ModelMap map) {
        map.addAttribute("message", "https://www.niaobulashi.com");
        return "hello";
    }

    /**
     * hello，异常错误
     */
    @RequestMapping(value = "/hello")
    public String hello() throws Exception {
        throw new Exception("发生错误");
    }

    @RequestMapping("/json")
    public String json() throws MyException {
        throw new MyException("发生错误2");
    }
}
