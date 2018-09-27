package cn.tedu.ht.mapper;

import cn.tedu.ht.pojo.User;
import cn.tedu.ht.pojo.UserInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface UserMapper {

    //查询全部的信息
    List<User> findAll();

    //状态的启动和停用
    //使用注解@Param的形式对map集合进行封装
    //key : value键值对
    void updateState(@Param(value = "userIds") String[] userIds,
                     @Param(value = "state") int state);

    //查询用户的总数据量
    int getUserTotalCount();

    //根据分页，查询当前分页的数据
    List<User> findUserByPages(@Param(value = "startRow") int startRow,
                               @Param(value = "pageSize") int pageSize);

    //查询上级领导的信息
    List<User> findManagerUser();

    //保存 到 user_p表中
    void saveUser(User user);

    //保存 到 user_info_p表中
    void saveUserInfo(UserInfo userInfo);

    //保存到 role_user_p 表中n
    void saveUserRole(@RequestParam(value = "userId") String userId,
                      @RequestParam(value = "roleId") String roleId);

    //根据userid删除中间表中的信息
    void deleteUserRole(String userId);

    //根据userid查询中间表中的信息
    List<String> findUserRoleByUserId(String userId);

    // 根据加密后的密码和用户名 查询数据库
    User checkLoginByUser(@Param(value = "userName") String userName,
                          @Param(value = "password") String password);

}
