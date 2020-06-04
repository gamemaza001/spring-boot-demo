package com.springboot.demo.Data.response;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class ResponseStatus {
    private Integer code;
    private String header;
    private String description;
}
