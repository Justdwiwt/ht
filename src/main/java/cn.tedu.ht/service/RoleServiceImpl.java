package cn.tedu.ht.service;

import cn.tedu.ht.mapper.RoleMapper;
import cn.tedu.ht.pojo.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public List<Role> findAll() {
        return roleMapper.findAll();
    }

    @Override
    public void saveRole(Role role) {
        String roleId = UUID.randomUUID().toString();
        role.setRoleId(roleId);
        roleMapper.saveRole(role);
    }

    @Override
    public void updateRole(Role role) {
        roleMapper.updateRole(role);
    }

    @Override
    public Role findRoleById(String roleId) {
        return roleMapper.findRoleById(roleId);
    }

    @Override
    public void deleteRole(String[] roleIds) {
        roleMapper.deleteRole(roleIds);
    }

}
