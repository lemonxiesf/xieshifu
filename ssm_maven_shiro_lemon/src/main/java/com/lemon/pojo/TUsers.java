package com.lemon.pojo;

import java.io.Serializable;

public class TUsers implements Serializable {

    private static final long serialVersionUID = -8204782940562715303L;

    private Integer userid;

    private Integer roleid;

    private String username;

    private String email;

    private String usersex;

    private Integer userage;

    private String userphone;

    private String useraccount;

    private String userpwd;

    private Float usersalary;

    private String initPassword;

    private String userStatus;

    private String usermark;

    //用于显示用户角色
    private String rolename;

    //用于权限分配
    private  String role;

    public String getRole() {
        return role;
    }

    public void setRole( String role ) {
        this.role = role;
    }

    private String ck;

    public String getCk() {
        return "<input type='checkbox' name='ids' value='"+ this.userid + "'>";
    }

    public void setCk( String ck ) {
        this.ck = ck;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename( String rolename ) {
        this.rolename = rolename;
    }


    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getUsersex() {
        return usersex;
    }

    public void setUsersex(String usersex) {
        this.usersex = usersex == null ? null : usersex.trim();
    }

    public Integer getUserage() {
        return userage;
    }

    public void setUserage(Integer userage) {
        this.userage = userage;
    }

    public String getUserphone() {
        return userphone;
    }

    public void setUserphone(String userphone) {
        this.userphone = userphone == null ? null : userphone.trim();
    }

    public String getUseraccount() {
        return useraccount;
    }

    public void setUseraccount(String useraccount) {
        this.useraccount = useraccount == null ? null : useraccount.trim();
    }

    public String getUserpwd() {
        return userpwd;
    }

    public void setUserpwd(String userpwd) {
        this.userpwd = userpwd == null ? null : userpwd.trim();
    }

    public Float getUsersalary() {
        return usersalary;
    }

    public void setUsersalary(Float usersalary) {
        this.usersalary = usersalary;
    }

    public String getUsermark() {
        return usermark;
    }

    public void setUsermark(String usermark) {
        this.usermark = usermark == null ? null : usermark.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail( String email ) {
        this.email = email;
    }

    public String getInitPassword() {
        return initPassword;
    }

    public void setInitPassword( String initPassword ) {
        this.initPassword = initPassword;
    }

    public String getUserStatus() {
        return userStatus;
    }

    public void setUserStatus( String userStatus ) {
        this.userStatus = userStatus;
    }


    @Override
    public String toString() {
        return "TUsers{" +
                "userid=" + userid +
                ", roleid=" + roleid +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", usersex='" + usersex + '\'' +
                ", userage=" + userage +
                ", userphone='" + userphone + '\'' +
                ", useraccount='" + useraccount + '\'' +
                ", userpwd='" + userpwd + '\'' +
                ", usersalary=" + usersalary +
                ", initPassword='" + initPassword + '\'' +
                ", userStatus='" + userStatus + '\'' +
                ", usermark='" + usermark + '\'' +
                ", rolename='" + rolename + '\'' +
                ", role='" + role + '\'' +
                ", ck='" + ck + '\'' +
                '}';
    }
}