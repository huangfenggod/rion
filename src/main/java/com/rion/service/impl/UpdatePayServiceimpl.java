package com.rion.service.impl;

import com.rion.mapper.AdminMapper;
import com.rion.mapper.PackMapper;
import com.rion.service.UpdatrePayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdatePayServiceimpl implements UpdatrePayService {

    @Autowired
    PackMapper packMapper;

    @Autowired
    AdminMapper adminMapper;

    @Override
    public int updatePay(String address) {

        int i = packMapper.selectByAddress(address);

        if (i<1){
            return 0;
        }
        i= adminMapper.updatePay(address);
        return i;
    }
}
