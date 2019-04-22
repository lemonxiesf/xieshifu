package com.lemon.system.service;

import com.lemon.pojo.TMenu;

import java.util.List;

public interface TMenuService {
    List<TMenu> queryMenusByRoleId( Integer roleId);
}
