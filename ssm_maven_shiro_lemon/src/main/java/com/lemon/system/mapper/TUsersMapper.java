package com.lemon.system.mapper;

import com.lemon.pojo.TUsers;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TUsersMapper {


    TUsers doLogin( @Param ("userAccount") String userAccount, @Param ("userPwd")String userPwd);

    TUsers findByAccount(String userAccount);

    List<TUsers> selectAll();

    int insert(TUsers tUsers);

    List<TUsers> findUserByUserIdOrUserName(TUsers user);

    int deleteMultiUser(@Param ( "ck" ) Integer [] ck);

    int updateUser(TUsers user);

    TUsers selectByPrimaryKey(int userId);

    TUsers findRoleByRoleId(Integer roleid);

    List<TUsers> selectNotIssue(String salaryMonth);

    //用户邮箱注册
    int addUser(TUsers user);

    //激活邮箱
    int updateActivate(@Param ( "email" )String email,@Param ( "initPassword" ) String initPassword );

    //邮箱登陆
    TUsers findByEmail(String email);
}
