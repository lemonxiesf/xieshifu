package com.lemon.system.mapper;

import com.lemon.pojo.TMenu;
import java.util.List;

public interface TMenuMapper {

    List<TMenu> queryMenusByRoleId( Integer roleId );


}