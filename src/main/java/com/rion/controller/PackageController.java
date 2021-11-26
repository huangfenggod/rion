package com.rion.controller;

import com.rion.pojo.RecommendUrl;
import com.rion.responseUtils.ResponsCode;
import com.rion.service.PackService;
import com.rion.service.impl.PackServiceimpl;
import org.apache.ibatis.annotations.Param;
import org.aspectj.apache.bcel.generic.RET;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class PackageController {
    @Autowired
    PackService packService;

    @RequestMapping(value = "/insert",method = RequestMethod.POST)
    @ResponseBody
    public ResponsCode insertAddress(@RequestParam("address") String address, HttpServletRequest request){
        address =address.replace(",","").trim();
        String uid= request.getParameter("uid");
        if (uid!=null){
            try {
                int res = packService.insert(address, Integer.valueOf(uid));
                if (res==-1){
                    return new ResponsCode<>(0,"提交的推广链接有误",null);
                }else if (res==0){
                    return new ResponsCode<>(0,"提交失败或重复",null);
                }else {
                    Integer pid = packService.selectId(address);
                    if (uid!=null){
                        return new ResponsCode<>(200,"提交成功",new RecommendUrl("http://puyuanzj.com:8080/?uid="+pid));
                    }else {
                        return new ResponsCode<>(200,"提交成功","推荐链接异常输入重新获取");
                    }
                }
            }catch (Exception e){
                return new ResponsCode<>(0,"提交的推广链接有误",null);
            }
        }
    int res= packService.insert(address);
    if (res==1){
        Integer pid = packService.selectId(address);
        if (uid!=null){
            return new ResponsCode<>(200,"提交成功",new RecommendUrl("http://puyuanzj.com:8080/?uid="+pid));
        }else {
            return new ResponsCode<>(200,"提交成功","推荐链接异常输入重新获取");
        }
    }else {return new ResponsCode<>(0,"提交失败或重复",null);}
    }
    @ResponseBody
    @RequestMapping(value = "/link",method = RequestMethod.POST)
    public ResponsCode queryRcommondUrl(@Param("address") String address){
        Integer id = packService.selectId(address);
        if (id!=null){
            return new ResponsCode<>(200,"提交成功",new RecommendUrl("http://puyuanzj.com:8080/?uid="+id));
        }else {
            return new ResponsCode<>(0,"没有钱包地址重新获取",null);
        }


    }





}
