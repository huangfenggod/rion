package com.rion.controller;

import com.alibaba.fastjson.JSONObject;
import com.rion.mapper.AdminMapper;
import com.rion.pojo.RecommendAll;
import com.rion.pojo.RecommendUrl;
import com.rion.pojo.packageDetail;
import com.rion.responseUtils.ResponsCode;
import com.rion.service.PackService;
import com.rion.service.Query;
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
import java.util.List;

@Controller
public class PackageController {
    @Autowired
    PackService packService;

    @Autowired
    Query query;

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
                        return new ResponsCode<>(200,"白名单添加成功",new RecommendUrl("http://puyuanzj.com:8080/?uid="+pid));
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
        if (pid!=null){
            return new ResponsCode<>(200,"白名单添加成功",new RecommendUrl("http://puyuanzj.com:8080/?uid="+pid));
        }else {
            return new ResponsCode<>(0,"提交失败",null);
        }
    }else {return new ResponsCode<>(0,"提交失败或重复",null);}
    }
    @ResponseBody
    @RequestMapping(value = "/link",method = RequestMethod.POST)
    public ResponsCode queryRcommondUrl(@Param("address") String address){
        Integer id = packService.selectId(address);
        if (id!=null){
            List<packageDetail> children = query.getChildren(address);
            int lengthOnly = query.countPidByAddress(address);
            int lengthAll =children.size();

            return new ResponsCode<>(200,"白名单添加成功",new RecommendAll("http://puyuanzj.com:8080/?uid="+id,
                    lengthOnly,lengthAll));
        }else {
            return new ResponsCode<>(0,"你还没有绑定过这个钱包地址",null);
        }


    }





}
