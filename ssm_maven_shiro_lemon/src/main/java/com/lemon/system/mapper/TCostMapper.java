package com.lemon.system.mapper;

import com.lemon.pojo.TCost;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TCostMapper {
    int deleteByPrimaryKey( Integer costid );

    int insert( TCost cost );

    TCost selectByPrimaryKey( @Param ( "costid" ) Integer costid );

    List<TCost> selectAll();

    int updateByPrimaryKey( TCost cost );

    List<TCost> findCostByCostIdOrCostName(TCost cost);

    int deleteMultiCost(@Param("ids") Integer[] ids);
}