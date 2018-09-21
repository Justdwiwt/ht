package cn.tedu.ht.service;

import cn.tedu.ht.pojo.Dept;

import java.util.List;

public interface DeptService {

    List<Dept> findAll();

    void updateState(String[] deptIds, int state);

    void deleteDept(String[] deptIds);

    List<Dept> findParentDept();

    void saveDept(Dept dept);

    Dept findDeptById(String deptId);

}
