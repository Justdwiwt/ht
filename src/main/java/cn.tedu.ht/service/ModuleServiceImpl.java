package cn.tedu.ht.service;

import cn.tedu.ht.mapper.ModuleMapper;
import cn.tedu.ht.pojo.Module;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModuleServiceImpl implements ModuleService {

    @Autowired
    private ModuleMapper moduleMapper;

    @Override
    public List<Module> findAll() {
        return moduleMapper.findAll();
    }

    @Override
    public List<Module> findParentModule() {
        return moduleMapper.findParentModule();
    }

    @Override
    public void saveModule(Module module) {
        moduleMapper.saveModule(module);
    }

}
