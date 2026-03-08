package com.newp.tliasproject.controller;

import com.newp.tliasproject.pojo.Emp;
import com.newp.tliasproject.pojo.EmpQueryParam;
import com.newp.tliasproject.pojo.PageResult;
import com.newp.tliasproject.pojo.Result;
import com.newp.tliasproject.service.EmpService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

//员工管理
@RestController
public class EmpController {
    Logger logger = LoggerFactory.getLogger(EmpController.class);
    @Autowired
    EmpService empService;
   @GetMapping("/emps")
//    public Result page(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer  pageSize, String
//                       name, Integer gender, @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate begin,@DateTimeFormat (pattern = "yyyy-MM-dd") LocalDate
//                       end) {
//     PageResult<Emp> pa= empService.page(page,pageSize,name,gender,begin,end);
//      return Result.suceess(pa);
//
//   }
    //这里直接传入实体类来代替全部的参数
   public Result page(EmpQueryParam empQueryParam) {
       PageResult<Emp> pa= empService.page(empQueryParam);
       return Result.suceess(pa);

   }
   @PostMapping("/emps")
   public   Result addEmp(@RequestBody Emp emp) {
       System.out.println(emp.toString());
       empService.save(emp);
       return Result.suceess();


   }

    //日志
}
