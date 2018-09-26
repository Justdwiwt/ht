package cn.tedu.ht.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/sysadmin/role/")
public class RoleController {


    @RequestMapping(value = "list")
    public String toRoleList() {
        return "/sysadmin/role/jRoleList";
    }

}
