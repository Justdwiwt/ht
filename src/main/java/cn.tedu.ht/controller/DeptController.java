package cn.tedu.ht.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DeptController {

    // 列表页面的跳转
    @RequestMapping(value = "/sysadmin/dept/list")
    public String toDeptList() {
        return "/sysadmin/dept/jDeptList";
    }

}
