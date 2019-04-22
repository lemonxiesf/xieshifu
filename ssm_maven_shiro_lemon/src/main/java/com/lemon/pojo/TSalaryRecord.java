package com.lemon.pojo;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

public class TSalaryRecord implements Serializable {

    private static final long serialVersionUID = 5781197044584410523L;

    private Integer salaryid;

    private Integer userid;

    @DateTimeFormat(pattern = "yyyy-MM")
    private Date salarymonth;

    private Date salarydate;

    private Float salarybasic;

    private Float salarycomm;

    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername( String username ) {
        this.username = username;
    }

    public Integer getSalaryid() {
        return salaryid;
    }

    public void setSalaryid(Integer salaryid) {
        this.salaryid = salaryid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Date getSalarymonth() {
        return salarymonth;
    }

    public void setSalarymonth(Date salarymonth) {
        this.salarymonth = salarymonth;
    }

    public Date getSalarydate() {
        return salarydate;
    }

    public void setSalarydate(Date salarydate) {
        this.salarydate = salarydate;
    }

    public Float getSalarybasic() {
        return salarybasic;
    }

    public void setSalarybasic(Float salarybasic) {
        this.salarybasic = salarybasic;
    }

    public Float getSalarycomm() {
        return salarycomm;
    }

    public void setSalarycomm(Float salarycomm) {
        this.salarycomm = salarycomm;
    }
}