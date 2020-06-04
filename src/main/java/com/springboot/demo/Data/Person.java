package com.springboot.demo.Data;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Person {
    private String id;
    private String name;
    private String phone;
}
