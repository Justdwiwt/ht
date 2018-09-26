package cn.tedu.ht.mapper;

import cn.tedu.ht.pojo.Role;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface RoleMapper {

    @Select(value = "select * from role_p")
    List<Role> findAll();

    @Insert(value = "insert into role_p (role_id, remarks,order_no) values(?,?,?,?)")
    void saveRole(Role role);

    @Update(value = "update role_p set name=#{name}, remarks=#{remarks}, order_no#{order_no} where role_id=#{role_id}")
    void updateRole(Role role);

    @Select(value = "select * from role_p where role_id=#{role_id}")
    Role findRoleById(String roleId);

    void deleteRole(String[] roleIds);

}
