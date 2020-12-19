package com.dc.boot.bean;

import lombok.*;
import org.springframework.stereotype.Component;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class User {
    private int id;
    private String username;
    private String password;
    private String avatar;
    private String introduction;
}

