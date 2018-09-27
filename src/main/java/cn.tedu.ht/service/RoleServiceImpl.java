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

    /**
     * 查找role_p所有数据
     *
     * @return {@code List<Role>}
     */
    @Override
    public List<Role> findAll() {
        return roleMapper.findAll();
    }

    /**
     * 保存role_p数据
     *
     * @param role Role
     */
    @Override
    public void saveRole(Role role) {
        //自动生成主键
        String roleId = UUID.randomUUID().toString();
        role.setRoleId(roleId);
        roleMapper.saveRole(role);
    }

    /**
     * 修改role_p
     *
     * @param role Role
     */
    @Override
    public void updateRole(Role role) {
        roleMapper.updateRole(role);
    }

    /**
     * 依据id查找role_p
     *
     * @param roleId Role
     * @return Role
     */
    @Override
    public Role findRoleById(String roleId) {
        return roleMapper.findRoleById(roleId);
    }

    /**
     * 防止数据的重复插入
     *
     * @param roleIds Role
     */
    @Override
    public void deleteRole(String[] roleIds) {
        roleMapper.deleteRole(roleIds);
    }

    @Override
    public void saveRoleModule(String roleId, String[] moduleIds) {
        roleMapper.saveRoleModule(roleId, moduleIds);
    }

}
