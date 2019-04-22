package com.lemon.system.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lemon.pojo.TUsers;
import com.lemon.system.mapper.TUsersMapper;
import com.lemon.system.service.TUserService;
import com.lemon.utils.pagingPlugin.context.*;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("tUserService")
@Transactional
public class TUserServiceImpl implements TUserService {

    @Autowired
    private TUsersMapper tUsersMapper;



    public int insert( TUsers tUsers ) {
        int count = tUsersMapper.insert ( tUsers );

        return count;
    }

    public TUsers selectByPrimaryKey( Integer userid ) {
        return tUsersMapper.selectByPrimaryKey ( userid );
    }

    public List<TUsers> selectAll() {

        return tUsersMapper.selectAll ();
    }

    public int updateByPrimaryKey( TUsers record ) {
        return 0;
    }

    public TUsers doLogin( String userAccount, String userPwd ) {
        return tUsersMapper.doLogin ( userAccount, userPwd );
    }

    @Override
    public TUsers findByAccount( String userAccount ) {
        return tUsersMapper.findByAccount ( userAccount );
    }

    @Override
    public TUsers findByEmail( String email ) {
        return tUsersMapper.findByEmail ( email );
    }

    @Override
    public PageInfo<TUsers> findUserByUserIdOrUserName( TUsers user ) {
        String username = user.getUsername ();
        if (StringUtils.isBlank ( username )) {
            user.setUsername ( null );
        }
        Integer pageNum = SystemContext.getPageNum();
        Integer pageSize = SystemContext.getPageSize();

        PageHelper.startPage(pageNum,pageSize);
        List<TUsers> userList = tUsersMapper.findUserByUserIdOrUserName ( user );
        PageInfo<TUsers> usersPageInfo=new PageInfo<> ( userList );
        return usersPageInfo;
    }

    @Override
    public boolean deleteMultiUser( Integer[] ck ) {
        int count = tUsersMapper.deleteMultiUser ( ck );
        if (count > 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean updateUser( TUsers user ) {
        int count = tUsersMapper.updateUser ( user );
            if (count > 0){
                return true;
            }
        return false;
    }

    @Override
    public TUsers findRoleByRoleId( Integer roleid ) {
        return tUsersMapper.findRoleByRoleId ( roleid );
    }

    @Override
    public List<TUsers> selectNotIssue( String salaryMonth ) {
        return this.tUsersMapper.selectNotIssue ( salaryMonth );
    }

    @Override
    public Integer addUser( TUsers user ) {
        int i = tUsersMapper.addUser ( user );
        System.err.println (i);
        return i;

    }

    @Override
    public int updateActivate( String email,String initPassword ) {
        return tUsersMapper.updateActivate (email,initPassword);
    }


}
