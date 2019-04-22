package com.lemon.expense.service;

import com.lemon.pojo.TExpense;
import com.lemon.pojo.TExpenseDetail;

import java.util.List;

public interface TExpenseDetailService {

    int deleteByPrimaryKey( Integer detailid );

    int insert( List<TExpenseDetail> record);

    TExpenseDetail selectByPrimaryKey( Integer detailid );

    List<TExpenseDetail> selectAll();

    int updateByPrimaryKey( TExpenseDetail record );

    TExpenseDetail findExpenseDetailByExpenseId(Integer expenseId);

}
