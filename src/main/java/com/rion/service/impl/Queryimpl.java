package com.rion.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rion.commons.Recursive;
import com.rion.mapper.AdminMapper;
import com.rion.mapper.PackMapper;
import com.rion.pojo.packageDetail;
import com.rion.service.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class Queryimpl implements Query {
    @Autowired
    AdminMapper adminMapper;

    @Autowired
    PackMapper packMapper;

    @Override
    public List<packageDetail> selectAll(int pageNum, int pageSize) {
//        PageHelper.offsetPage(pageNum,pageSize);
        PageHelper.startPage(pageNum,pageSize);
        List<packageDetail> packageDetails = adminMapper.selectAll();
        PageInfo<packageDetail> pageInfo = new PageInfo<>(packageDetails);
        return pageInfo.getList();
    }

    @Override
    public packageDetail selectByAddress(String address) {
        return adminMapper.selectByAddress(address);
    }

    @Override
    public List<packageDetail> getChildren(String address) {
        List<packageDetail> selectAll = adminMapper.selectAll();
        Integer id = packMapper.selectIdByAddress(address);
        if (id==null){
            return null;
        }
        Recursive recursive = new Recursive(id, selectAll);
        return recursive.getChildren();
    }

    @Override
    public int countPidByAddress(String address) {
        Integer integer = packMapper.selectIdByAddress(address);
        if (integer==null){
            return 0;
        }
        return adminMapper.countPidById(integer);
    }
}
