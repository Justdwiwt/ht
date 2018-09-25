package cn.tedu.ht.mapper;

import cn.tedu.ht.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {

    List<User> findAll();

    int getUserTotalCount();

    List<User> findUserByPages(@Param(value = "startRom") int startRow,
                               @Param(value = "pageSize") int pageSize);

}
