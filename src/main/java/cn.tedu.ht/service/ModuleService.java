package cn.tedu.ht.service;

import cn.tedu.ht.pojo.Module;

import java.util.List;

public interface ModuleService {

    List<Module> findAll();

    List<Module> findParentModule();

    void saveModule(Module module);

    List<String> findRoleModuleByRoleId(String roleId);

    void updateState(String[] moduleIds, int state);

}
