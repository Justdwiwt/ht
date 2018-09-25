package cn.tedu.ht.mapper;

import cn.tedu.ht.pojo.User;
import cn.tedu.ht.pojo.UserInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {

    //查询全部的信息
    List<User> findAll();

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

}
