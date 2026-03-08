package com.newp.tliasproject.service;

import com.newp.tliasproject.pojo.dept;

import java.util.List;

public interface DeptService {
    public List<dept> selectAllService();
    public void deleteService(Integer id);

    public void addService(dept deptin);
    public dept  updateService(Integer id);
    public void motifyService(dept depin);

}
