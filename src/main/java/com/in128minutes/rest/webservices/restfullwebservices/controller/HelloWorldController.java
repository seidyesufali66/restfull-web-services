package com.in128minutes.rest.webservices.restfullwebservices.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/hello")
public class HelloWorldController {
    @GetMapping
    public String sayHello() {
        return "Hello World this is the first rest service to implement retriving the data";
    }
    @GetMapping("/bean")
    public String helloWroldBean() {
        return new HelloWorldBean("Hello World Bean this is the first rest service to implement retriving the data").toString();

    }
    // why  we need to use the path varible paramenter
    @GetMapping("/path-variable/{name}")
    public String helloWroldBeanPathVariable(@PathVariable String name) {
        return new HelloWorldBean("Hello World Bean this is the first rest service to implement retriving the data with path variable "+name).toString();
    }

}
