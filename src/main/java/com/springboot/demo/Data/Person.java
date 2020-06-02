package com.springboot.demo.Data;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Person {
    private String name;
    private String nickName;
    private int age;
    private String email;
    private String tel;
}
