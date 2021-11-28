package com.rion.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.ibatis.annotations.Param;

@Data
@AllArgsConstructor
public class RecommendAll {
    private String url;
    private int lengthOnly;
    private int lengthAll;
}
