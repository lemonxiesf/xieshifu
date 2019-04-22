package com.lemon.system.service;

import com.github.pagehelper.PageInfo;
import com.lemon.pojo.TCost;

import java.util.List;

public interface TCostService {
    int deleteByPrimaryKey( Integer costid );

    int insert( TCost record );

    TCost selectByPrimaryKey( Integer costid );

    List<TCost> selectAll();

    Boolean updateByPrimaryKey( TCost record );


    PageInfo<TCost> findCostByCostIdOrCostName( TCost cost );

    int deleteMultiCost(Integer [] ids);

}