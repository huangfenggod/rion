package com.rion.service;
import com.rion.pojo.packageDetail;
import org.springframework.stereotype.Service;


public interface PackService {
   int insert(String address);
   Integer selectId(String address);
   int insert(String address,int uid);

//   packageDetail select(String address);
//   packageDetail selectAll();

}
