package com.springboot.demo.Data.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors(chain = true)
public class ResponseModel<T> implements Serializable {
    private ResponseStatus status;
    @JsonProperty("data")
    private T dataObj;

    public ResponseModel(ResponseStatus status, T dataObj) {
        this.status = status;
        this.dataObj = dataObj;
    }

    public ResponseModel(ResponseStatus status) {
        this.status = status;
    }

    public ResponseModel(T dataObj) {
        this.status = new ResponseStatus()
                .setCode(1000)
                .setDescription("Success");
        this.dataObj = dataObj;
    }

}

