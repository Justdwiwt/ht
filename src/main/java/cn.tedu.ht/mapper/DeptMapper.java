package cn.tedu.ht.mapper;

import cn.tedu.ht.pojo.Dept;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DeptMapper {

    List<Dept> findAll();

    //状态的启动和停用
    //使用注解@Param的形式对map集合进行封装
    //key : value键值对
    void updateState(@Param(value = "deptIds") String[] deptIds,
                     @Param(value = "state") int state);

    //批量删除
    void deleteDept(String[] deptIds);

    //查询所有的上级部门
    List<Dept> findParentDept();

    //插入一条部门信息
    void saveDept(Dept dept);

    // 根据id查询部门信息
    Dept findDeptById(String deptId);

    // 修改页面的数据回显
    Dept findDeptBackById(String deptId);

}
