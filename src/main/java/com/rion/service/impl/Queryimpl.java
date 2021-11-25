package com.rion.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rion.mapper.AdminMapper;
import com.rion.pojo.packageDetail;
import com.rion.service.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class Queryimpl implements Query {
    @Autowired
    AdminMapper adminMapper;

    @Override
    public List<packageDetail> selectAll(int pageNum, int pageSize) {
//        PageHelper.offsetPage(pageNum,pageSize);
        PageHelper.startPage(pageNum,pageSize);
        List<packageDetail> packageDetails = adminMapper.selectAll();
        PageInfo<packageDetail> pageInfo = new PageInfo<>(packageDetails);
        return pageInfo.getList();



    }
}
