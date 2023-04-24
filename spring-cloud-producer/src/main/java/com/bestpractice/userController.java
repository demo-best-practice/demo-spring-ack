package com.bestpractice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class userController {
    @Autowired
    DiscoveryClient client;

    @RequestMapping("/hello")
    public String index(HttpServletRequest request) {
        //System.out.println("=====call producer=====");
        ServiceInstance instance = client.getLocalServiceInstance();
        String msg = "/hello, host: " + instance.getHost() + ", service_id: "
                + instance.getServiceId() + ", port: "+ instance.getPort();
        //System.out.println(msg);
        return msg;
    }
}
