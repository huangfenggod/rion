package com.rion.service;
import com.rion.pojo.packageDetail;
import org.springframework.stereotype.Service;

import java.util.List;

public interface Query {
    List<packageDetail> selectAll(int pageNum,int pageSize);

}
