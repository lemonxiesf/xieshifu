package com.lemon.expense.mapper;

import com.lemon.pojo.TExpenseDetail;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface TExpenseDetailMapper {
    int deleteByPrimaryKey( Integer detailid );

    int insert( @Param ( "detailList" ) List<TExpenseDetail> detailList );

    TExpenseDetail selectByPrimaryKey( Integer detailid );

    List<TExpenseDetail> selectAll();

    int updateByPrimaryKey( TExpenseDetail record );


}