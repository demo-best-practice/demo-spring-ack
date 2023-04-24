package com.bestpractice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;

@RestController
public class userController {
    @Autowired
    userService userService;

    @RequestMapping("/hello")
    public String index(HttpServletRequest request) {
        //System.out.println("=====call consumer=====");
        String msg = "/hello, consumer starts ";
        //System.out.println(msg);
        return msg + userService.index();
    }

}
