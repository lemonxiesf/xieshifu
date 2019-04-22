package com.lemon.system.service;

import com.github.pagehelper.PageInfo;
import com.lemon.pojo.TUsers;

import java.util.List;

public interface TUserService {

    int insert(TUsers tUsers);

    TUsers selectByPrimaryKey(Integer userid);

    List<TUsers> selectAll();

    TUsers findByAccount(String userAccount);

    //用户邮箱登陆
    TUsers findByEmail(String email);

    PageInfo<TUsers> findUserByUserIdOrUserName(TUsers user);

    boolean deleteMultiUser(Integer [] ck);

    boolean updateUser(TUsers user);

    TUsers findRoleByRoleId(Integer roleid);

    List<TUsers> selectNotIssue(String salaryMonth);
    //用户邮箱注册
    Integer addUser(TUsers user);

    //激活邮箱
    int updateActivate(String email,String initPassword );

}
