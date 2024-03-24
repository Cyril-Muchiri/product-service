package io.github.cyrilmuchiri.productservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("api")
@Slf4j
public class HelloWorldController {

    @GetMapping("/hello")
    public String testHello() {
        log.info(null);
        return "Hello world";
    }
}
