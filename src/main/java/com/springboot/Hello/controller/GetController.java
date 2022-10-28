package com.springboot.Hello.controller;

import com.springboot.Hello.domain.MemberDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController // dispatcherServlet이 매핑해줄 Controller를 등록
@RequestMapping("/api/v1/get-api")
@Slf4j
public class GetController {

    // RequestMapping 이란  controller가 할당 된 후 어떤 메서드를 실행할지 연결해주는 어노테이션
    @RequestMapping(name = "/hello", method = RequestMethod.GET)    // hello를 get으로 지정
    public String hello() {
        log.info("hello로 요청이 들어왔습니다.");
        return "Hello World";
    }

    @GetMapping(value = "/name")
    public String getName() {
        log.info("getName으로 요청이 들어왔습니다.");
        return "Suyeon";
    }

    @GetMapping(value = "/variable1/{variable}")
    public String getVariable(@PathVariable String varialbe) {
        log.info("getVariable1로 요청이 들어왔습니다. variable:{}", varialbe);
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
    @GetMapping(value = "/request2")
    public String getVariable2(@RequestParam Map<String, String> param) {
        param.entrySet().forEach((map)->{
            System.out.printf("key:%s value:%s", map.getKey(), map.getValue());
        });
        return "request2가 호출 완료되었습니다";
    }

    @GetMapping(value = "/request3")
    public String getRequestParam(MemberDto memberDto){
        return memberDto.toString();
    }
}
