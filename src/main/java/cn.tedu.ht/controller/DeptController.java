package cn.tedu.ht.controller;

import cn.tedu.ht.pojo.Dept;
import cn.tedu.ht.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class DeptController {

    @Autowired
    private DeptService deptService;

//    // 列表页面的跳转
//    @RequestMapping(value = "/sysadmin/dept/list")
//    public String toDeptList() {
//        return "/sysadmin/dept/jDeptList";
//    }

    @RequestMapping(value = "/sysadmin/dept/list")
    public String toDeptList(Model model) {
        List<Dept> deptList = deptService.findAll();
        model.addAttribute("deptList", deptList);
        return "/sysadmin/dept/jDeptList";
    }

    @RequestMapping(value = "/sysadmin/dept/stop")
    public String toStop(String deptId) {
        int state = 0;
        deptService.updateState(deptId, state);
        return "redirect:/sysadmin/dept/list";
    }

    @RequestMapping(value = "/sysadmin/dept/start")
    public String toStart(String deptId) {
        int state = 1;
        deptService.updateState(deptId, state);
        return "redirect:/sysadmin/dept/list";
    }

}
