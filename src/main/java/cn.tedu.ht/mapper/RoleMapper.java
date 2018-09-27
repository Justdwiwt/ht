package cn.tedu.ht.mapper;

import cn.tedu.ht.pojo.Role;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface RoleMapper {

    @Select(value = "select * from role_p")
    List<Role> findAll();

    @Insert(value = "insert into role_p (role_id, name, remarks, order_no) values (#{roleId}, #{name}, #{remarks}, #{orderNo})")
    void saveRole(Role role);

    @Update(value = "update role_p set name=#{name}, remarks=#{remarks}, order_no#{orderNo} where role_id=#{roleId}")
    void updateRole(Role role);

    @Select(value = "select * from role_p where role_id=#{roleId}")
    Role findRoleById(String roleId);

    void deleteRole(String[] roleIds);

    void saveRoleModule(@Param(value = "roleId") String roleId,
                        @Param(value = "moduleIds") String[] moduleIds);
}
