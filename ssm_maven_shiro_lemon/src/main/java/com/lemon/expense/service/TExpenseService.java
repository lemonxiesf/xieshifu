package com.lemon.expense.service;

import com.github.pagehelper.PageInfo;
import com.lemon.pojo.PoExpense;
import com.lemon.pojo.TAuditRecord;
import com.lemon.pojo.TExpense;
import com.lemon.pojo.TExpenseDetail;

import java.util.Date;
import java.util.List;

public interface TExpenseService {


    int insert( TExpense auditRecord );

    TExpense selectByPrimaryKey( Integer expenseid );

    int updateByPrimaryKey(String expensestate, Integer expenseid ,TAuditRecord tAuditRecord);

    PageInfo<TExpense> findExpenseByUserId(Integer userid);

    PageInfo<TExpense> expenseCondition( PoExpense poExpense );

    PageInfo<TExpense> managerAudit(PoExpense poExpense);

    List<TExpenseDetail> findExpenseDetailByExpenseId( Integer expenseId);

    int selectLastId();

    PageInfo<TExpense> financeAudit(PoExpense poExpense);


}
