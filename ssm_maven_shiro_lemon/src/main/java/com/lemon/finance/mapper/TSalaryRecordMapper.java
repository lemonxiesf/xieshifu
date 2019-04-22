package com.lemon.finance.mapper;

import com.lemon.pojo.TSalaryRecord;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TSalaryRecordMapper {

    int insert( TSalaryRecord record );

    TSalaryRecord selectByPrimaryKey( Integer salaryid );

    List<TSalaryRecord> selectAll( @Param ( "username" ) String username,@Param ( "salarymonth" ) String salarymonth );

    List<TSalaryRecord> findByUserId(Integer userId);
}