package com.lemon.expense.service;

import com.lemon.pojo.TAuditRecord;

import java.util.List;

public interface TAuditRecordService {
    int deleteByPrimaryKey( Integer auditid );

    int insert( TAuditRecord auditRecord );

    TAuditRecord selectByPrimaryKey( Integer auditid );

    List<TAuditRecord> selectAll();

    int updateByPrimaryKey( TAuditRecord record );

    List<TAuditRecord> findAuditRecordByExpenseId(Integer expenseId);

}