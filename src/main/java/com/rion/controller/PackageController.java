package com.rion.controller;

import com.rion.responseUtils.ResponsCode;
import com.rion.service.PackService;
import com.rion.service.impl.PackServiceimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PackageController {
    @Autowired
    PackService packService;

    @RequestMapping(value = "/insert",method = RequestMethod.POST)
    @ResponseBody
    public ResponsCode insertAddress(@RequestParam("address") String address){
    int res= packService.insert(address);
    if (res==1){

        return new ResponsCode<String>(200,"成功");
    }else {return new ResponsCode<String>(0,"提交失败或重复");}
    }





}
