package com.lemon.finance.service;

import com.github.pagehelper.PageInfo;
import com.lemon.pojo.TSalaryRecord;

import java.util.List;

public interface TSalaryRecordService {

    int insert( TSalaryRecord record );

    TSalaryRecord selectByPrimaryKey( Integer salaryid );

    PageInfo<TSalaryRecord> selectAll(String username, String salarymonth );

    PageInfo<TSalaryRecord> findByUserId(Integer userId);

}
