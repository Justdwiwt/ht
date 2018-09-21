package cn.tedu.ht.controller;

import cn.tedu.ht.pojo.Dept;
import cn.tedu.ht.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    public String toStop(@RequestParam(value = "deptId", defaultValue = "0") String[] deptIds) {
        int state = 0;
        deptService.updateState(deptIds, state);
        return "redirect:/sysadmin/dept/list";
    }

    @RequestMapping(value = "/sysadmin/dept/start")
    public String toStart(@RequestParam(value = "deptId") String[] deptIds) {
        int state = 1;
        deptService.updateState(deptIds, state);
        return "redirect:/sysadmin/dept/list";
    }

    @RequestMapping(value = "/sysadmin/dept/delete")
    public String deleteDept(@RequestParam(value = "deptId", defaultValue = "0") String[] deptIds) {
        deptService.deleteDept(deptIds);
        return "redirect:/sysadmin/dept/list";
    }

    @RequestMapping(value = "/sysadmin/dept/tosave")
    public String toSaveDept(Model model) {
        List<Dept> parentDeptList = deptService.findParentDept();
        model.addAttribute("parentDeptList", parentDeptList);
        return "/sysadmin/dept/jDeptSave";
    }

    @RequestMapping(value = "/sysadmin/dept/save")
    public String saveDept(Dept dept, Model model) {
        String deptId = dept.getDeptId();
        Dept checkDept = deptService.findDeptById(deptId);
        if (checkDept != null) {
            model.addAttribute("errorInfo", "该部门编号已存在");
            return "forward:/sysadmin/dept/tosave";
        }
        deptService.saveDept(dept);
        return "redirect:/sysadmin/dept/list";
    }


    @RequestMapping(value = "/sysadmin/dept/toupdate")
    public String toUpdateDept(String deptId) {
        Dept dept = deptService.findDeptById(deptId);
        return "/sysadmin/dept/jDeptUpdate";
    }

}
