package com.javawhizz.spring_security_social_login.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserInfo {

    private String id;
    private String name;
    private String email;
    private String login;
    private String avatarUrl;
}
