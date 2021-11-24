package com.rion.controller;

import com.rion.responseUtils.ResponsCode;
import com.rion.service.Query;
import com.rion.service.UpdatrePayService;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.rion.pojo.packageDetail;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class AdminController {
        @Autowired
        Query query;

        @Autowired
        UpdatrePayService updatrePayService;

        @ResponseBody
        @RequestMapping(value = "/getDetail")
        public ResponsCode getDetail(@RequestParam("pageNum")int pageNum, @RequestParam("pageSize") int pageSize){
                List<packageDetail> detailList = query.selectAll(pageNum,pageSize);
                return new ResponsCode<List<packageDetail>>(200,detailList);
        }

        @ResponseBody
        @RequestMapping(value = "/update",method = RequestMethod.POST)
        public ResponsCode UpdatePay(@RequestParam("address") String address){

                int i = updatrePayService.updatePay(address);
                if (i>0){
                        return new ResponsCode<String>(200,address);
                }else {
                        return new ResponsCode<String>(0,"修改失败");
                }



        }




}