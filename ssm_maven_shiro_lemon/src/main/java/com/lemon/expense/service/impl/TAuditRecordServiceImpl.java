package com.lemon.expense.service.impl;

import com.lemon.expense.mapper.TAuditRecordMapper;
import com.lemon.expense.service.TAuditRecordService;
import com.lemon.pojo.TAuditRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class TAuditRecordServiceImpl implements TAuditRecordService {

    @Autowired
    private TAuditRecordMapper tAuditRecordMapper;



    @Override
    public int deleteByPrimaryKey( Integer auditid ) {
        return 0;
    }

    @Override
    public int insert( TAuditRecord auditRecord ) {
        return tAuditRecordMapper.insert ( auditRecord );
    }

    @Override
    public TAuditRecord selectByPrimaryKey( Integer auditid ) {
        return null;
    }

    @Override
    public List<TAuditRecord> selectAll() {
        return null;
    }

    @Override
    public int updateByPrimaryKey( TAuditRecord record ) {
        return 0;
    }

    @Override
    public List<TAuditRecord> findAuditRecordByExpenseId( Integer expenseId ) {
        return tAuditRecordMapper.findAuditRecordByExpenseId ( expenseId );
    }
}
