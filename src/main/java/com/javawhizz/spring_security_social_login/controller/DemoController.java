package com.javawhizz.spring_security_social_login.controller;

import com.javawhizz.spring_security_social_login.model.UserInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/v1/demo")
public class DemoController {

    @GetMapping
    public ResponseEntity<String> hello(@AuthenticationPrincipal OAuth2User principal){
        //Extract user details
        UserInfo userInfo = UserInfo.builder()
                .id(principal.getAttribute("id"))
                .name(principal.getAttribute("name"))
                .email(principal.getAttribute("email"))
                .login(principal.getAttribute("login"))
                .avatarUrl(principal.getAttribute("avatar-url"))
                .build();


        //Log user details
        log.info("Authenticated User Details");
        log.info("Id: {}", userInfo.getId());
        log.info("Name: {}", userInfo.getName());
        log.info("Email: {}", userInfo.getEmail());
        log.info("GitHub Username: {}", userInfo.getLogin());
        log.info("All Attributes: {}", principal.getAttributes());
        return ResponseEntity.ok("Hello from secure endpoint");
    }
}
