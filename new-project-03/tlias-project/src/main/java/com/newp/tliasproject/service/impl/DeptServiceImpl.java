package com.newp.tliasproject.service.impl;

import com.newp.tliasproject.Mapper.DeptMapper;
import com.newp.tliasproject.pojo.dept;
import com.newp.tliasproject.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    DeptMapper deptMappersd;

    @Override
    public List<dept> selectAllService() {

            List<dept> deptlist=  deptMappersd.selectAllMapper();

            return deptlist;
    }
//删除部门
    @Override
    public void deleteService(Integer id) {

          deptMappersd.deleteMapper(id);

    }
//增加部门
    @Override
    public void addService(dept deptin) {
        LocalDateTime now = LocalDateTime.now();
        deptin.setCreateTime(now);
        deptin.setUpdateTime(now);

        deptMappersd.AddMapper(deptin);

    }
//修改信息，根据输入的id来回显
    @Override
    public dept updateService(Integer id) {

       dept deptio= deptMappersd.selectMapperById(id);

        return deptio;
    }
//传入的数据是name,id
    @Override
    public void motifyService(dept depin) {

        LocalDateTime now = LocalDateTime.now();
        depin.setUpdateTime(now);
        deptMappersd.modifyMapper(depin);


    }

}
