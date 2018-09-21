package cn.tedu.ht.service;

import cn.tedu.ht.pojo.Dept;

import java.util.List;

public interface DeptService {

    List<Dept> findAll();

    void updateState(String deptId, int state);

}
