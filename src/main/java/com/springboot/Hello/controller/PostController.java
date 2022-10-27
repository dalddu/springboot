package com.springboot.Hello.controller;

import com.springboot.Hello.domain.MemberDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/get-api")

public class PostController {
    @RequestMapping(value = "/domain", method = RequestMethod.POST)
    public String postExample() {
        return "Hello Post API";
    }

    @PostMapping("/member")
    public String postMember(@RequestBody Map<String, Object> postData) {
        StringBuilder sb = new StringBuilder(); // Builder Pattern
        postData.entrySet().forEach(map -> sb.append(map.getKey() + ":" + map.getValue() + "\n"));
        return sb.toString();
    }

    @PostMapping("/member2")
    public String postMember(@RequestBody MemberDto memberDto) {
        return memberDto.toString();
    }


    /*
    Put에 ResponseEntity적용
    ResponseEntity는 get, post, put, delete, patch 다른 메소드에도 다 쓸 수 있음
    Http Response Header와 Body를 구성하기 쉬움
     */
    @PostMapping("/member3")
    public ResponseEntity<MemberDto> putMember(@RequestBody MemberDto memberDto) {
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(memberDto);
    }
}