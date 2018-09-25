package cn.tedu.ht.service;

import cn.tedu.ht.pojo.User;
import cn.tedu.ht.tool.PageBean;

import java.util.List;

public interface UserService {
    //查询全部的信息
    public List<User> findAll();

    //查询用户的总数据量
    public int getUserTotalCount();

    //根据分页，查询当前分页的数据
    public PageBean<User> findUserByPages(int currentPage, int pageSize);

    //查询上级领导的信息
    public List<User> findManagerUser();

    //新增操作
    public void saveUser(User user);
}
