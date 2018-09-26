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

    @RequestMapping(value = "list")
    public String toRoleList(Model model) {
        List<Role> roleList = roleService.findAll();
        model.addAttribute("roleList", roleList);
        return "/sysadmin/role/jRoleList";
    }

    @RequestMapping(value = "tosave")
    public String toSave(Role role) {
        return "/sysadmin/role/jRoleSave";
    }

    @RequestMapping(value = "save")
    public String saveRole(Role role) {
        roleService.saveRole(role);
        return "redirect:/sysadmin/role/list";
    }

    @RequestMapping(value = "toupdate")
    public String toUpdateRole(String roleId, Model model) {
        Role role = roleService.findRoleById(roleId);
        model.addAttribute("role", role);
        return "/sysadmin/role/jRoleUpdate";
    }

    @RequestMapping(value = "update")
    public String updateRole(Role role) {
        roleService.updateRole(role);
        return "redirect:/sysadmin/role/list";
    }

    @RequestMapping(value = "delete")
    public String deleteRole(@RequestParam(value = "roleId", defaultValue = "0")
                                     String[] roleIds) {
        roleService.deleteRole(roleIds);
        return "redirect:/sysadmin/role/list";
    }

    @RequestMapping(value = "toview")
    public String toViewRole(String roleId, Model model) {
        Role role = roleService.findRoleById(roleId);
        model.addAttribute("role", role);
        return "/sysadmin/role/jRoleView";
    }

}
