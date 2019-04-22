package com.lemon.system.service.impl;

import com.lemon.pojo.TMenu;
import com.lemon.system.mapper.TMenuMapper;
import com.lemon.system.service.TMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TMenuServiceImpl implements TMenuService {

    @Autowired
    private TMenuMapper tMenuMapper;

    public List<TMenu> queryMenusByRoleId( Integer roleId ) {
        return tMenuMapper.queryMenusByRoleId ( roleId );
    }
}
