package com.bestpractice;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class userService {
    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod="helloFallback")
    public String index() {
        return restTemplate.getForEntity("http://SPRING-CLOUD-PRODUCER/hello",
                String.class).getBody();
    }

    public String helloFallback(Throwable ex) {
        ex.printStackTrace();
        return "error";
    }
}
