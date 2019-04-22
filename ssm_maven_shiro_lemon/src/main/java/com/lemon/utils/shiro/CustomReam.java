package com.lemon.utils.shiro;

import com.lemon.pojo.TMenu;
import com.lemon.pojo.TUsers;
import com.lemon.system.service.TMenuService;
import com.lemon.system.service.TUserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class CustomReam extends AuthorizingRealm {

    @Autowired
    private TUserService tUserService;

    @Autowired
    private TMenuService tMenuService;

    @Override
    public void setName( String name ) {
        super.setName ( "CustomReam" );
    }

    /**
     * 权限分配
     * @param principalCollection
     * @return
     */
    protected AuthorizationInfo doGetAuthorizationInfo( PrincipalCollection principalCollection ) {
        System.out.println ("进入角色授权");
        TUsers user = (TUsers) principalCollection.getPrimaryPrincipal ();
        //查询权限菜单
        List<TMenu> tMenus = tMenuService.queryMenusByRoleId ( user.getRoleid () );
        List <String> permissions=new ArrayList<> (  );
        for (TMenu t:tMenus) {
            String url = t.getUrl ();
            //将权限菜单地址替换为shiro权限分配格式
            String s = url.replaceAll ( "/", ":" );
            permissions.add ( s );
        }
        TUsers role = tUserService.findRoleByRoleId ( user.getRoleid () );
        SimpleAuthorizationInfo  info=new SimpleAuthorizationInfo (  );
        info.addStringPermissions ( permissions );
        info.addRole ( role.getRole () );
        return info;
    }

    /**
     * 登陆认证
     * @param token
     * @return
     * @throws AuthenticationException
     */
    protected AuthenticationInfo doGetAuthenticationInfo( AuthenticationToken token ) throws AuthenticationException {
        System.out.println ("正在登陆...");
        //用户输入的 用户名密码
        String username = (String)token.getPrincipal ();
        String credentials = new String((char[])token.getCredentials ());
        System.out.println ("用户名/邮箱"+username+"=====密码"+credentials);



        TUsers user =  tUserService.findByAccount ( username );
        TUsers byEmail = tUserService.findByEmail ( username );

        System.out.println (user);
        System.out.println (byEmail);
        if (user == null && byEmail ==null){
            System.out.println ("当前用户不存在");
            return null;
        }

        SimpleAuthenticationInfo info = null;
        if(user!=null){
            if(credentials.equals (user.getUserpwd ())){
                System.out.println ("用户账号登陆");
                info =  new SimpleAuthenticationInfo ( user, user.getUserpwd (), this.getName ());
            }
        }else{
            System.out.println ("用户邮箱登陆");
            byEmail.setUsername ( byEmail.getEmail () );
            info= new SimpleAuthenticationInfo ( byEmail, byEmail.getUserpwd (), this.getName ());
        }
        return  info;
    }








}
