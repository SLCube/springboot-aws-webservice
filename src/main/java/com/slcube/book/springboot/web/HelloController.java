package com.slcube.book.springboot.web;

import com.slcube.book.springboot.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping(value = "/hello")
    public String hello() {
        return "hello";
    }

    @GetMapping(value = "/hello/dto")
    public HelloResponseDto helloDto(@RequestParam("name") String name, @RequestParam int amount) {
        return new HelloResponseDto(name, amount);
    }
}
