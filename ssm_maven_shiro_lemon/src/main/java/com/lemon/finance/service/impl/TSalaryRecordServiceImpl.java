package com.lemon.finance.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lemon.finance.mapper.TSalaryRecordMapper;
import com.lemon.finance.service.TSalaryRecordService;
import com.lemon.pojo.TSalaryRecord;
import com.lemon.utils.pagingPlugin.context.SystemContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TSalaryRecordServiceImpl implements TSalaryRecordService {

    @Autowired
    private TSalaryRecordMapper tSalaryRecordMapper;

    @Override
    public int insert( TSalaryRecord record ) {
        return tSalaryRecordMapper.insert ( record );
    }

    @Override
    public TSalaryRecord selectByPrimaryKey( Integer salaryid ) {
        return null;
    }

    @Override
    public PageInfo<TSalaryRecord> selectAll(String username, String salarymonth ) {
        Integer pageNum = SystemContext.getPageNum ();
        Integer pageSize=SystemContext.getPageSize ();
        PageHelper.startPage ( pageNum,pageSize );
        PageInfo<TSalaryRecord> pageInfo=new PageInfo<> ( tSalaryRecordMapper.selectAll (username,salarymonth) );
        return pageInfo;
    }

    @Override
    public PageInfo<TSalaryRecord> findByUserId( Integer userId ) {
        Integer pageNum = SystemContext.getPageNum ();
        Integer pageSize=SystemContext.getPageSize ();
        PageHelper.startPage ( pageNum,pageSize );
        PageInfo<TSalaryRecord> pageInfo=new PageInfo<> (  tSalaryRecordMapper.findByUserId ( userId ));
        return pageInfo;
    }
}
