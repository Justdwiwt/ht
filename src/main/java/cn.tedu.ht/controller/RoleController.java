package cn.tedu.ht.controller;

import cn.tedu.ht.pojo.Role;
import cn.tedu.ht.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping(value = "/sysadmin/role/")
public class RoleController {

    @Autowired
    private RoleService roleService;

    /**
     * 查询全部的角色信息
     *
     * @param model roleList
     * @return /sysadmin/role/jRoleList
     */
    @RequestMapping(value = "list")
    public String toRoleList(Model model) {
        List<Role> roleList = roleService.findAll();
        model.addAttribute("roleList", roleList);
        return "/sysadmin/role/jRoleList";
    }

    /**
     * 点击新增按钮，页面的跳转
     *
     * @param role Role
     * @return /sysadmin/role/jRoleSave
     */
    @SuppressWarnings("unused")
    @RequestMapping(value = "tosave")
    public String toSave(Role role) {
        return "/sysadmin/role/jRoleSave";
    }

    /**
     * 点击保存按钮，进行数据的保存
     *
     * @param role Role
     * @return redirect:/sysadmin/role/list
     */
    @RequestMapping(value = "save")
    public String saveRole(Role role) {
        roleService.saveRole(role);
        return "redirect:/sysadmin/role/list";
    }

    /**
     * 点击修改按钮，页面的跳转
     *
     * @param roleId Role
     * @param model  role
     * @return /sysadmin/role/jRoleUpdate
     */
    @RequestMapping(value = "toupdate")
    public String toUpdateRole(String roleId, Model model) {
        Role role = roleService.findRoleById(roleId);
        model.addAttribute("role", role);
        return "/sysadmin/role/jRoleUpdate";
    }

    /**
     * 点击更新按钮，更新数据库
     *
     * @param role Role
     * @return redirect:/sysadmin/role/list
     */
    @RequestMapping(value = "update")
    public String updateRole(Role role) {
        roleService.updateRole(role);
        return "redirect:/sysadmin/role/list";
    }

    /**
     * 点击删除按钮，批量删除数据
     *
     * @param roleIds Role
     * @return redirect:/sysadmin/role/list
     */
    @RequestMapping(value = "delete")
    public String deleteRole(@RequestParam(value = "roleId", defaultValue = "0")
                                     String[] roleIds) {
        roleService.deleteRole(roleIds);
        return "redirect:/sysadmin/role/list";
    }

    /**
     * 点击查询按钮，页面的跳转
     *
     * @param roleId Role
     * @param model  role
     * @return /sysadmin/role/jRoleView
     */
    @RequestMapping(value = "toview")
    public String toViewRole(String roleId, Model model) {
        Role role = roleService.findRoleById(roleId);
        model.addAttribute("role", role);
        return "/sysadmin/role/jRoleView";
    }

}
