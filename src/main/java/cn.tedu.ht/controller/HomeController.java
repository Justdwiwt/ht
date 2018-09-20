package cn.tedu.ht.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    //转向欢迎页面
    @RequestMapping("/home")
    public String home() {
        return "/home/fmain";
    }

    //转向tilte标题栏页面
    @RequestMapping("/title")
    public String title() {
        return "/home/title";
    }

//    //转向home的左侧页面
//    @RequestMapping("/homeLeft")
//    public String homeLeft() {
//        return "/home/left";
//    }
//
//    //转向home的操作页面
//    @RequestMapping("/homeMain")
//    public String homeMain() {
//        return "/home/main";
//    }
//
//    //转向cargo的left
//    @RequestMapping(value = "/cargoLeft")
//    public String cargoLeft() {
//        return "/cargo/left";
//    }
//
//    //转向cargo的main
//    @RequestMapping(value = "/cargoMain")
//    public String cargoMain() {
//        return "/cargo/main";
//    }
//
//    //转向baseinfo的left
//    @RequestMapping(value = "/baseinfoLeft")
//    public String baseinfoLeft() {
//        return "/baseinfo/left";
//    }
//
//    //转向baseinfo的main
//    @RequestMapping(value = "/baseinfoMain")
//    public String baseinfoMain() {
//        return "/baseinfo/main";
//    }
//
//    @RequestMapping("/sysadminLeft")
//    public String sysadminLeft() {
//        return "/sysadmin/left";
//    }
//
//    @RequestMapping("/sysadminMain")
//    public String sysadminMain() {
//        return "/sysadmin/main";
//    }

    //使用RestFul定义请求方法
    @RequestMapping(value = "/{moduleName}/Left.action")
    public String moduleLeft(@PathVariable String moduleName) {
        return moduleName + "/left";
    }

    @RequestMapping(value = "/{moduleName}/Main.action")
    public String moduleMain(@PathVariable String moduleName) {
        return moduleName + "/main";
    }
}
