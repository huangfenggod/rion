package com.rion.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import com.rion.pojo.packageDetail;
import java.util.List;

@Repository
@Mapper
public interface AdminMapper {

   public List<packageDetail> selectAll();
   public int updatePay(@Param("address") String address);
   public packageDetail selectByAddress(@Param("address") String address);
}
