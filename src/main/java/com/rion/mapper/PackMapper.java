package com.rion.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Date;
@Mapper
public interface PackMapper {

    int insertByAddress(@Param("address") String address, @Param("time") Date time,@Param("pid") Integer pid,
                        @Param("pay") Integer pay);
    int selectByAddress(@Param("address") String address);

}
