package cn.tedu.ht.service;

import cn.tedu.ht.pojo.Role;

import java.util.List;

public interface RoleService {

    List<Role> findAll();

    void saveRole(Role role);

    void updateRole(Role role);

    Role findRoleById(String roleId);

    void deleteRole(String[] roleIds);

    void saveRoleModule(String roleId, String[] moduleIds);
}
