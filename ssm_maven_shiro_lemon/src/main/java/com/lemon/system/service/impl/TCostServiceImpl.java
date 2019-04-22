package com.lemon.system.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lemon.pojo.TCost;
import com.lemon.system.mapper.TCostMapper;
import com.lemon.system.service.TCostService;
import com.lemon.utils.pagingPlugin.context.SystemContext;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TCostServiceImpl implements TCostService {

    @Autowired
    private TCostMapper tCostMapper;

    @Override
    public int deleteByPrimaryKey( Integer costid ) {
        return 0;
    }

    @Override
    public int insert( TCost cost ) {
        return tCostMapper.insert ( cost );
    }

    @Override
    public TCost selectByPrimaryKey( Integer costid ) {
        return tCostMapper.selectByPrimaryKey ( costid );
    }

    @Override
    public List<TCost> selectAll() {
        List<TCost> tCosts = tCostMapper.selectAll ();
        return tCosts;
    }

    @Override
    public Boolean updateByPrimaryKey( TCost cost ) {
        int count = tCostMapper.updateByPrimaryKey ( cost );
        if (count > 0) {
            return true;
        }

        return false;
    }

    @Override
    public PageInfo<TCost> findCostByCostIdOrCostName( TCost cost ) {
        if (StringUtils.isBlank ( cost.getCostname () )) {
            cost.setCostname ( null );
        }
        Integer pageNum = SystemContext.getPageNum();
        Integer pageSize = SystemContext.getPageSize ();
        PageHelper.startPage ( pageNum,pageSize );
        PageInfo<TCost> pageInfo= new PageInfo<> ( tCostMapper.findCostByCostIdOrCostName ( cost ) );
        return pageInfo;
    }

    @Override
    public int deleteMultiCost( Integer[] ids ) {
        return tCostMapper.deleteMultiCost ( ids );
    }
}
