package cn.tedu.ht.mapper;

import cn.tedu.ht.pojo.Dept;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DeptMapper {

    List<Dept> findAll();

    // 使用注解对map集合进行封装
    void updateState(@Param(value = "deptId") String deptId,
                     @Param(value = "state") int state);

}
