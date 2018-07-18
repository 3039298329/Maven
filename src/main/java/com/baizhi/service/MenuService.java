package com.baizhi.service;

import com.baizhi.entity.Menu;

import java.util.List;

/**
 * Created by wyx on 2018/7/5.
 */
public interface MenuService {
    //增加菜单
    public void insertMenu(Menu menu);
    //查找全部
    public List<Menu> queryAll();
    //删除菜单
    public void drop(int id);
}
