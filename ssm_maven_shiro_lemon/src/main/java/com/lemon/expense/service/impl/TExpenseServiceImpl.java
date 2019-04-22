package com.lemon.expense.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lemon.expense.mapper.TExpenseMapper;
import com.lemon.expense.service.TAuditRecordService;
import com.lemon.expense.service.TExpenseDetailService;
import com.lemon.expense.service.TExpenseService;
import com.lemon.pojo.PoExpense;
import com.lemon.pojo.TAuditRecord;
import com.lemon.pojo.TExpense;
import com.lemon.pojo.TExpenseDetail;
import com.lemon.utils.pagingPlugin.context.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class TExpenseServiceImpl implements TExpenseService {

    @Autowired
    private TExpenseMapper tExpenseMapper;

    @Autowired
    private TAuditRecordService tAuditRecordService;

    @Autowired
    private TExpenseDetailService tExpenseDetailService;

    @Override
    public int updateByPrimaryKey( String expensestate, Integer expenseid,TAuditRecord tAuditRecord ) {
        //添加一条审核记录
        tAuditRecordService.insert (tAuditRecord);
        //修改报销单审核状态
        return tExpenseMapper.updateByPrimaryKey ( expensestate,expenseid );
    }

    @Override
    public int insert( TExpense record ) {

        return tExpenseMapper.insert ( record );
    }

    @Override
    public PageInfo<TExpense> findExpenseByUserId( Integer userid ) {
        int pageNum=SystemContext.getPageNum ();
        int pageSize=SystemContext.getPageSize ();
        PageHelper.startPage (pageNum,pageSize);
        List<TExpense> list = tExpenseMapper.findExpenseByUserId ( userid );
        PageInfo<TExpense> pageInfo=new PageInfo<> ( list );

        return pageInfo;
    }

    @Override
    public PageInfo<TExpense> expenseCondition( PoExpense poExpense ) {
        int pageNum=SystemContext.getPageNum ();
        int pageSize=SystemContext.getPageSize ();
        PageHelper.startPage (pageNum,pageSize);
        List<TExpense> expenseList = tExpenseMapper.expenseCondition ( poExpense);
        PageInfo<TExpense> pageInfo=new PageInfo<> ( expenseList );
        return pageInfo;
    }

    @Override
    public PageInfo<TExpense> managerAudit(PoExpense poExpense) {
        int pageNum=SystemContext.getPageNum ();
        int pageSize=SystemContext.getPageSize ();
        PageHelper.startPage (pageNum,pageSize);
        List<TExpense> expenseList = tExpenseMapper.managerAudit (poExpense);
        PageInfo<TExpense> pageInfo=new PageInfo<> (  expenseList);
        return pageInfo;
    }

    @Override
    public  List<TExpenseDetail> findExpenseDetailByExpenseId( Integer expenseId ) {
        return tExpenseMapper.findExpenseDetailByExpenseId ( expenseId );
    }

    @Override
    public int selectLastId() {
        return tExpenseMapper.selectLastId ();
    }

    @Override
    public PageInfo<TExpense> financeAudit( PoExpense poExpense ) {
        int pageNum=SystemContext.getPageNum ();
        int pageSize=SystemContext.getPageSize ();
        PageHelper.startPage (pageNum,pageSize);
        PageInfo<TExpense> pageInfo=new PageInfo<> (tExpenseMapper.financeAudit ( poExpense ) );
        return pageInfo;
    }


    @Override
    public TExpense selectByPrimaryKey( Integer expenseid ) {
        return tExpenseMapper.selectByPrimaryKey ( expenseid );
    }

}
