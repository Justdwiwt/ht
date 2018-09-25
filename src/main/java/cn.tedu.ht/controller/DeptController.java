package cn.tedu.ht.controller;

import cn.tedu.ht.pojo.Dept;
import cn.tedu.ht.service.DeptService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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

    //根据实际的业务逻辑，在页面跳转时，先查询所有的列表信息
    @RequestMapping(value = "/sysadmin/dept/list")
    public String toDeptList(Model model) {
        List<Dept> deptList = deptService.findAll();
        model.addAttribute("deptList", deptList);
        return "/sysadmin/dept/jDeptList";
    }

    //部门状态的停用
    @RequestMapping(value = "/sysadmin/dept/stop")
    public String toStop(@RequestParam(value = "deptId", defaultValue = "0") String[] deptIds) {
        int state = 0;
        deptService.updateState(deptIds, state);
        return "redirect:/sysadmin/dept/list";
    }

    //部门状态的启动
    @RequestMapping(value = "/sysadmin/dept/start")
    public String toStart(@RequestParam(value = "deptId", defaultValue = "0") String[] deptIds) {
        int state = 1;
        deptService.updateState(deptIds, state);
        return "redirect:/sysadmin/dept/list";
    }

    //批量删除
    @RequestMapping(value = "/sysadmin/dept/delete")
    public String deleteDept(@RequestParam(value = "deptId", defaultValue = "0") String[] deptIds) {
        deptService.deleteDept(deptIds);
        return "redirect:/sysadmin/dept/list";
    }

    //点击新增按钮，实现页面跳转
    @RequestMapping(value = "/sysadmin/dept/tosave")
    public String toSaveDept(Model model) {
        List<Dept> parentDeptList = deptService.findParentDept();
        model.addAttribute("parentDeptList", parentDeptList);
        return "/sysadmin/dept/jDeptSave";
    }

    //新增页面的保存方法
    @SuppressWarnings("SpringMVCViewInspection")
    @RequestMapping(value = "/sysadmin/dept/save")
    public String saveDept(Dept dept, Model model) {
        String deptId = dept.getDeptId();
        if (deptId == null || "".equals(deptId))
            return "forward:/sysadmin/dept/tosave";
        Dept checkDept = deptService.findDeptById(deptId);
        if (checkDept != null) {
            model.addAttribute("errorInfo", "该部门编号已存在");
            return "forward:/sysadmin/dept/tosave";
        }
        deptService.saveDept(dept);
        return "redirect:/sysadmin/dept/list";
    }

    //点击修改按钮，实现页面的跳转
    @RequestMapping(value = "/sysadmin/dept/toupdate")
    public String toUpdateDept(String deptId, Model model) {
        Dept dept = deptService.findDeptBackById(deptId);
        List<Dept> parentDeptList = deptService.findParentDept();
        model.addAttribute("dept", dept);
        model.addAttribute("parentDeptList", parentDeptList);
        return "/sysadmin/dept/jDeptUpdate";
    }

    //点击更新页面，实现数据的更新
    @SuppressWarnings("SpringMVCViewInspection")
    @RequestMapping(value = "/sysadmin/dept/update")
    public String updateDept(Dept dept, Model model) {
        String deptId = dept.getDeptId();
        if (deptId == null || "".equals(deptId))
            return "forward:/sysadmin/dept/tosave";
        Dept checkDept = deptService.findDeptById(deptId);
        if (checkDept != null) {
            model.addAttribute("errorInfo", "该部门编号已存在");
            return "forward:/sysadmin/dept/tosave";
        }
        return "redirect:/sysadmin/dept/list";
    }

    // 查看
    @RequestMapping(value = "/sysadmin/dept/toview")
    public String toView() {

        return "/sysadmin/dept/jDeptView";
    }

    // ajax异步校验deptID
    @RequestMapping(value = "/sysadmin/dept/checkDeptId")
    @ResponseBody   // json对象存入response中
    public JSONObject checkDeptId(String deptId) {
        JSONObject jsonObject = new JSONObject();
        Dept dept = deptService.findDeptById(deptId);
        if (dept == null) {
            jsonObject.put("result", "false");
        } else {
            jsonObject.put("result", "true");
        }
        return jsonObject;
    }

}
