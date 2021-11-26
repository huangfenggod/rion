package com.rion.service.impl;

import com.rion.mapper.PackMapper;
import com.rion.pojo.packageDetail;
import com.rion.service.PackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
@Service
public class PackServiceimpl implements PackService {
    @Autowired
    PackMapper packMapper;


    @Override
    public int insert(String address) {
        int i =0;
        i= packMapper.selectByAddress(address);
        if (i==1){return 0;}
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = dateFormat.format(date);
        i= packMapper.insertByAddress(address,new Date(),Integer.valueOf(0),Integer.valueOf(0));
        return i;
    }

    @Override
    public int insert(String address, int uid) {
        if (packMapper.selectHasId(uid)==0){
            return -1;//如果查询的推荐码uid不存在则返回-1
        }

        int i =0;
        i= packMapper.selectByAddress(address);
        if (i==1){return 0;}
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = dateFormat.format(date);
        i= packMapper.insertByAddress(address,new Date(),uid,Integer.valueOf(0));
        return i;


    }

    @Override
    public Integer selectId(String address) {
        Integer i = packMapper.selectIdByAddress(address);
        return i;
    }

    //    @Override
//    public packageDetail select(String address) {
//        return null;
//    }
//
//    @Override
//    public packageDetail selectAll() {
//        return null;
//    }
}
