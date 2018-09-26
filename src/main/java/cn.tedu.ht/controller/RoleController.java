package cn.tedu.ht.controller;

import cn.tedu.ht.pojo.Role;
import cn.tedu.ht.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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

}
