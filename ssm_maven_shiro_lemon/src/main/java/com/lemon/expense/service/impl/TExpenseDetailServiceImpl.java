package com.lemon.expense.service.impl;

import com.lemon.expense.mapper.TExpenseDetailMapper;
import com.lemon.expense.mapper.TExpenseMapper;
import com.lemon.expense.service.TExpenseDetailService;
import com.lemon.expense.service.TExpenseService;
import com.lemon.pojo.TExpense;
import com.lemon.pojo.TExpenseDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TExpenseDetailServiceImpl implements TExpenseDetailService {

    @Autowired
    private TExpenseDetailMapper tExpenseDetailMapper;

    @Autowired
    private TExpenseService tExpenseService;

    @Override
    public int deleteByPrimaryKey( Integer detailid ) {
        return 0;
    }

    @Override
    public int insert( List<TExpenseDetail> record ) {

        //查询最后一个添加的报销单编号
        int expenseId = tExpenseService.selectLastId ();
        for (TExpenseDetail ex:record) {
            ex.setExpenseid ( expenseId );
        }

        //添加报销单明细
        return tExpenseDetailMapper.insert ( record );
    }

    @Override
    public TExpenseDetail selectByPrimaryKey( Integer detailid ) {
        return null;
    }

    @Override
    public List<TExpenseDetail> selectAll() {
        return null;
    }

    @Override
    public int updateByPrimaryKey( TExpenseDetail record ) {
        return 0;
    }

    @Override
    public TExpenseDetail findExpenseDetailByExpenseId( Integer expenseId ) {
        return null;
    }
}
