package com.springboot.Hello.controller;

import org.apache.coyote.Request;
import org.springframework.web.bind.annotation.*;

@RestController("/api/v1/get-api") // dispatcherServlet이 매핑해줄 Controller를 등록
public class HelloController {

    // RequestMapping 이란  controller가 할당 된 후 어떤 메서드를 실행할지 연결해주는 어노테이션
    @RequestMapping(name = "/hello", method = RequestMethod.GET)    // hello를 get으로 지정
    public String hello() {
        return "Hello World";
    }

    @GetMapping(value = "/name")
    public String getName() {
        return "Suyeon";
    }

    @GetMapping(value = "/variable1/{variable}")
    public String getVariable(@PathVariable String varialbe) {
        return varialbe;
    }

    @GetMapping(value = "/variable2/{variable}")
    public String getVariable2(@PathVariable("varaiable") String var) {
        return var;
    }

    @GetMapping(value = "/request1")
    public String getVariable2(@RequestParam String name,@RequestParam String email, @RequestParam String organization) {
        return String.format("%s %s %s", name, email, organization);
    }
}
