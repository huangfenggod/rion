package com.rion.responseUtils;

import lombok.Data;
@Data
public class ResponsCode<T> {
    private Integer code;
    private T data;
    private String msg;
    public ResponsCode(int code,String msg,T data){
        this.code=code;
        this.data=data;
        this.msg=msg;
    }
}
