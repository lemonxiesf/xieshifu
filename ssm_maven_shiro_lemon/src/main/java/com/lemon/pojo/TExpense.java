package com.lemon.pojo;

import lombok.Data;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Data
@ToString
public class TExpense implements Serializable {

    private static final long serialVersionUID = 9187984179106859666L;

    private Integer expenseid;

    private Integer userid;

    private String expensename;

    private Float expensetotal;

    @DateTimeFormat(pattern = "yyyy/MM/dd HH:mm:ss")
    private Date expensedate;

    private String expensestate;

    private String expensedesc;

    private List<TExpenseDetail> tExpenseDetails;

    public List<TExpenseDetail> gettExpenseDetails() {
        return tExpenseDetails;
    }

    public void settExpenseDetails( List<TExpenseDetail> tExpenseDetails ) {
        this.tExpenseDetails = tExpenseDetails;
    }

    //用于显示用户名称
    private String username;

    private String imagePath;

    public void setExpensename(String expensename) {
        this.expensename = expensename == null ? null : expensename.trim();
    }

    public void setExpensestate(String expensestate) {
        this.expensestate = expensestate == null ? null : expensestate.trim();
    }


    public void setExpensedesc(String expensedesc) {
        this.expensedesc = expensedesc == null ? null : expensedesc.trim();
    }

    @Override
    public String toString() {
        return "TExpense{" +
                "expenseid=" + expenseid +
                ", userid=" + userid +
                ", expensename='" + expensename + '\'' +
                ", expensetotal=" + expensetotal +
                ", expensedate=" + expensedate +
                ", expensestate='" + expensestate + '\'' +
                ", expensedesc='" + expensedesc + '\'' +
                ", tExpenseDetails=" + tExpenseDetails +
                ", username='" + username + '\'' +
                ", imagePath='" + imagePath + '\'' +
                '}';
    }
}