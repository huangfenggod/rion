package com.rion.responseUtils;

import lombok.Data;
@Data
public class ResponsCode<T> {
    private Integer code;
    private T data;
    public ResponsCode(Integer code,T data){
        this.code=code;
        this.data=data;
    }
}
