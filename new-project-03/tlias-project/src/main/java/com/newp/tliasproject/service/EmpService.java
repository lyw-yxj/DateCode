package com.newp.tliasproject.service;

import com.newp.tliasproject.pojo.Emp;
import com.newp.tliasproject.pojo.EmpQueryParam;
import com.newp.tliasproject.pojo.PageResult;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public interface EmpService {


//    public PageResult<Emp> page(Integer start, Integer pageSize, String name, Integer gender, LocalDate begin, LocalDate
//            end);
    public PageResult<Emp> page(EmpQueryParam param);
    public void save(Emp emp);

}
