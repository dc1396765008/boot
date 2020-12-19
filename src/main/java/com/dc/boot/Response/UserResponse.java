package com.dc.boot.Response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserResponse implements Serializable {
    private int code;
    private String message;
    private Object data;
}
