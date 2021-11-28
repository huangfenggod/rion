package com.rion.pojo;

import lombok.Data;

import java.util.List;

@Data
public class PackageDetailChildren {
    public PackageDetailChildren(List<packageDetail> children,int lengthOnly,int lengthAll){
        this.children=children;
        this.lengthOnly=lengthOnly;
        this.lengthAll=lengthAll;
    }

    private List<packageDetail> children;
    private int lengthOnly;
    private int lengthAll;


}
