package cn.tedu.ht.controller;

import cn.tedu.ht.pojo.Module;
import cn.tedu.ht.service.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping(value = "/sysadmin/module/")
public class ModuleController {

    @Autowired
    private ModuleService moduleService;

    @RequestMapping(value = "list")
    public String toModuleList(Model model) {
        List<Module> moduleList = moduleService.findAll();
        model.addAttribute("moduleList", moduleList);
        return "/sysadmin/module/jModuleList";
    }

    @RequestMapping(value = "tosave")
    public String toModuleSave(Model model) {
        List<Module> parentModuleList = moduleService.findParentModule();
        model.addAttribute("parentModuleList", parentModuleList);
        return "/sysadmin/module/jModuleSave";
    }

    @RequestMapping(value = "save")
    public String saveModule(Module module) {
        String uuid = UUID.randomUUID().toString();
        module.setModuleId(uuid);
        moduleService.saveModule(module);
        return "redirect:/sysadmin/module/list";
    }

}
