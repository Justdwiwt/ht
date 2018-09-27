package cn.tedu.ht.mapper;

import cn.tedu.ht.pojo.Module;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ModuleMapper {

    List<Module> findAll();

    @Select(value = "select * from module_p where ctype <> 3")
    List<Module> findParentModule();

    @Insert(value = "insert into module_p (module_id, parent_id, name, ctype, state, order_no, remark)" +
            "values (#{moduleId}, #{parentId}, #{name}, #{ctype}, #{state}, #{orderNo}, #{remark})")
    void saveModule(Module module);

    List<String> findRoleModuleByRoleId(String roleId);

    void updateState(@Param(value = "moduleIds") String[] moduleIds,
                     @Param(value = "state") int state);

}
