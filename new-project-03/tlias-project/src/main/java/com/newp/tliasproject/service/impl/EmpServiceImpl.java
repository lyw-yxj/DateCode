package com.newp.tliasproject.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.newp.tliasproject.Mapper.EmpExprMapper;
import com.newp.tliasproject.Mapper.EmpMapper;
import com.newp.tliasproject.pojo.Emp;
import com.newp.tliasproject.pojo.EmpExpr;
import com.newp.tliasproject.pojo.EmpQueryParam;
import com.newp.tliasproject.pojo.PageResult;
import com.newp.tliasproject.service.EmpService;
import org.apache.ibatis.reflection.ArrayUtil;
import org.apache.ibatis.transaction.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {
@Autowired
    EmpMapper empMapper;
@Autowired
EmpExprMapper empExprMapper;
//    @Override
//    public PageResult<Emp> page(Integer start, Integer pageSize, String name, Integer gender, LocalDate begin, LocalDate
//            end) {
//
//        Long total=empMapper.count();
//        Integer startI=(start-1)*pageSize;
//        List<Emp> listemp=empMapper.list(startI,pageSize);
//
//        return new PageResult<Emp>(total,listemp);
//
//
//    }
    //pageHelper

//@Override
//public PageResult<Emp> page(Integer start, Integer pageSize, String name,Integer gender,LocalDate begin,LocalDate end) {
//
//    //设置分页参数
//    PageHelper.startPage(start, pageSize);
//    List<Emp> listemp=empMapper.list(name,gender,begin,end);
//    Page<Emp> p = PageHelper.getLocalPage();
//
// 41行：返回结果（不变）
//    return new PageResult<>(p.getTotal(), listemp);
//
//
//}
    @Override
public PageResult<Emp> page(EmpQueryParam empQueryParam) {

    //设置分页参数
    PageHelper.startPage(empQueryParam.getPage(), empQueryParam.getPageSize());
    List<Emp> listemp=empMapper.list( empQueryParam);
    Page<Emp> p = PageHelper.getLocalPage();

 //41行：返回结果（不变）
    return new PageResult<>(p.getTotal(), listemp);
//数据
}
//事务管理
  @Transactional
    @Override
    public void save(Emp emp) {
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.insert(emp);

       List<EmpExpr>empExprs= emp.getExprList();
      if(!CollectionUtils.isEmpty(empExprs)){
          empExprs.forEach(empExpr -> {empExpr.setEmpId(emp.getId());
              System.out.println("OKOO");
          });
          empExprMapper.insearch(empExprs);

      }
    }
}



