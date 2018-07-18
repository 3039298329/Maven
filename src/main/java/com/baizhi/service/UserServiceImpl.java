package com.baizhi.service;

import com.baizhi.dao.UserDao;
import com.baizhi.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by wyx on 2018/7/8.
 */
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDao userDao;
    //用户添加
    @Override
    public void insertUser(User user) {
        userDao.addUser(user);
    }

    //用户删除
    @Override
    public void drop(int id) {
        userDao.delete(id);
    }

    //用户修改
    @Override
    public void modify(User user) {
        userDao.update(user);
    }

    @Override
    public List<User> queryAllUser() {
        return userDao.selectAllUser();
    }

    //用户查所有
    @Override
    public List<User> queryAll(int beginNum, int perNum) {
        return userDao.selectAll(beginNum,perNum);
    }

    //用户查一个
    @Override
    public User queryOne(int id) {
        return userDao.selectOne(id);
    }

    //查询所有的条数
    @Override
    public int countUser() {
        return userDao.count();
    }
    //根据注册的时间查询用户的数量
    @Override
    public int queryCountByRegistTime(int registTime) {
        return userDao.selectCountByRegistTime(registTime);
    }
}
