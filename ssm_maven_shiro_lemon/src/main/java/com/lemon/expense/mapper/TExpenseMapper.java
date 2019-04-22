package com.lemon.expense.mapper;

import com.github.pagehelper.PageInfo;
import com.lemon.pojo.PoExpense;
import com.lemon.pojo.TExpense;
import com.lemon.pojo.TExpenseDetail;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface TExpenseMapper {
    int deleteByPrimaryKey( Integer expenseid );

    int insert( TExpense record );

    TExpense selectByPrimaryKey( Integer expenseid );

    List<TExpense> selectAll();

    int updateByPrimaryKey( @Param ( "expensestate" ) String expensestate,@Param ( "expenseid" ) Integer expenseid );

    List<TExpense> findExpenseByUserId(Integer userid);

    List<TExpense> expenseCondition( PoExpense poExpense);

    List<TExpense> managerAudit(PoExpense poExpense);

    List<TExpense> financeAudit(PoExpense poExpense);

    List<TExpenseDetail> findExpenseDetailByExpenseId( Integer expenseId);

    int selectLastId();

    int updateFinanceAuditState();
}