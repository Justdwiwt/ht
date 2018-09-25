package cn.tedu.ht.service;

import cn.tedu.ht.mapper.DeptMapper;
import cn.tedu.ht.pojo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptMapper deptMapper;

    /**
     * 查询所有
     *
     * @return Dept
     */
    @Override
    public List<Dept> findAll() {
        return deptMapper.findAll();
    }

    /**
     * 状态的启动和停用
     *
     * @param deptIds id
     * @param state   状态
     */
    @Override
    public void updateState(String[] deptIds, int state) {
        deptMapper.updateState(deptIds, state);
    }

    /**
     * 批量删除
     *
     * @param deptIds id
     */
    @Override
    public void deleteDept(String[] deptIds) {
        deptMapper.deleteDept(deptIds);
    }

    /**
     * 查询所有的上级部门
     *
     * @return Dept
     */
    @Override
    public List<Dept> findParentDept() {
        return deptMapper.findParentDept();
    }

    /**
     * 插入一条部门信息
     *
     * @param dept Dept
     */
    @Override
    public void saveDept(Dept dept) {
        deptMapper.saveDept(dept);
    }

    /**
     * 根据id查询部门信息
     *
     * @param deptId id
     * @return Dept
     */
    @Override
    public Dept findDeptById(String deptId) {
        return deptMapper.findDeptById(deptId);
    }

    /**
     * 修改页面的数据回显
     *
     * @param deptId id
     * @return Dept
     */
    @Override
    public Dept findDeptBackById(String deptId) {
        return deptMapper.findDeptBackById(deptId);
    }

}
