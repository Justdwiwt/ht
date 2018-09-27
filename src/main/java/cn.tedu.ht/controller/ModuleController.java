package cn.tedu.ht.controller;

import cn.tedu.ht.pojo.Module;
import cn.tedu.ht.service.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping(value = "/sysadmin/module/")
public class ModuleController {

    @Autowired
    private ModuleService moduleService;

    /**
     * 页面的跳转
     *
     * @param model moduleList
     * @return /sysadmin/module/jModuleList
     */
    @RequestMapping(value = "list")
    public String toModuleList(Model model) {
        List<Module> moduleList = moduleService.findAll();
        model.addAttribute("moduleList", moduleList);
        return "/sysadmin/module/jModuleList";
    }

    /**
     * 点击新增按钮，跳转新增页面
     *
     * @param model parentModuleList
     * @return /sysadmin/module/jModuleSave
     */
    @RequestMapping(value = "tosave")
    public String toModuleSave(Model model) {
        List<Module> parentModuleList = moduleService.findParentModule();
        model.addAttribute("parentModuleList", parentModuleList);
        return "/sysadmin/module/jModuleSave";
    }

    /**
     * 点击保存按钮，进行数据的新增
     *
     * @param module Module
     * @return redirect:/sysadmin/module/list
     */
    @RequestMapping(value = "save")
    public String saveModule(Module module) {
        String uuid = UUID.randomUUID().toString();
        module.setModuleId(uuid);
        moduleService.saveModule(module);
        return "redirect:/sysadmin/module/list";
    }

    /**
     * 查看模块信息
     *
     * @return /sysadmin/module/jModuleView
     */
    @RequestMapping(value = "toview")
    public String toView() {
        return "/sysadmin/module/jModuleView";
    }

    /**
     * 更新模块
     *
     * @return /sysadmin/module/jModuleUpdate
     */
    @RequestMapping(value = "toupdate")
    public String toModuleUpdate() {
        return "/sysadmin/module/jModuleUpdate";
    }

    /**
     * 部门状态的停用
     *
     * @param moduleIds array
     * @return redirect:/sysadmin/module/list
     */
    @RequestMapping(value = "stop")
    public String toStop(@RequestParam(value = "moduleId",
            defaultValue = "0") String[] moduleIds) {
        int state = 0;
        moduleService.updateState(moduleIds, state);
        return "redirect:/sysadmin/module/list";
    }

    /**
     * 部门状态的启动
     *
     * @param moduleIds array
     * @return redirect:/sysadmin/module/list
     */
    @RequestMapping(value = "start")
    public String toStart(@RequestParam(value = "moduleId",
            defaultValue = "0") String[] moduleIds) {
        int state = 1;
        moduleService.updateState(moduleIds, state);
        return "redirect:/sysadmin/module/list";
    }

}
