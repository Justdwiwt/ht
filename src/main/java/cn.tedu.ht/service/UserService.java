package cn.tedu.ht.service;

import cn.tedu.ht.pojo.User;
import cn.tedu.ht.tool.PageBean;

import java.util.List;

@SuppressWarnings("unused")
public interface UserService {

    // 查询全部的信息
    List<User> findAll();

    // 查询用户的总数据量
    int getUserTotalCount();

    // 根据分页，查询当前分页的数据
    PageBean<User> findUserByPages(int currentPage, int pageSize);

    // 查询上级领导的信息
    List<User> findManagerUser();

    // 新增操作
    void saveUser(User user);

    // 保存信息到中间表中
    void saveUserRole(String userId, String roleIds);

    // 根据userid查询中间表中的信息
    List<String> findUserRoleByUserId(String userId);

    // 更新user状态
    void updateState(String[] userIds, int state);

    // 根据加密后的密码和用户名 查询数据库
    User checkLoginByUser(String userName, String password);

}
