package cn.tedu.ht.service;

import cn.tedu.ht.pojo.User;
import cn.tedu.ht.tool.PageBean;

import java.util.List;

public interface UserService {

    List<User> findAll();

    int getUserTotalCount();

    PageBean<User> findUserByPages(int currentPage, int pageSize);

}
