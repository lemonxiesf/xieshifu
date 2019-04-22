package com.lemon.expense.mapper;

import com.lemon.pojo.TAuditRecord;
import java.util.List;

public interface TAuditRecordMapper {
    int deleteByPrimaryKey( Integer auditid );

    int insert( TAuditRecord auditRecord );

    TAuditRecord selectByPrimaryKey( Integer auditid );

    List<TAuditRecord> selectAll();

    int updateByPrimaryKey( TAuditRecord record );

    List<TAuditRecord> findAuditRecordByExpenseId(Integer expenseId);
}