package com.newp.tliasproject.controller;

import com.newp.tliasproject.pojo.Result;
import com.newp.tliasproject.pojo.dept;
import com.newp.tliasproject.service.DeptService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.ibatis.annotations.Delete;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class DeptController {
    private static final Logger logger = LoggerFactory.getLogger(DeptController.class);
    @Autowired
    DeptService deptService;
        //返回数据,限制只能使用get的方法进行
        @GetMapping("/depts")
        public Result SelectAllController()
        {

            List<dept> deptlist=  deptService.selectAllService();
            Result result =  Result.suceess(deptlist);
            return result;
        }

        //删除部门
//    @DeleteMapping("/depts")
//    public void DeleteController(HttpServletRequest  request){
//            //方式一使用基本的httpServletRequest 方式进行获得数据
//
//           String  id=    request.getParameter("id");
//           Integer  idInt=         Integer.parseInt(id);
//           System.out.println("获得部门数据"+id);
//
//
//    }
        //第二种方式，前端传递的参数名和服务器的参数名是一致的,如果前端传来的不一致，就要使用注解
    @DeleteMapping("/depts")
    public Result DeleteController(Integer id) {
        //注意返回给前端的数据都要是一个result的格式
       logger.info("用户id"+id);
       deptService.deleteService(id);
       return Result.suceess();

    }
    //增加部门，使用的是一个部门类
    @PostMapping("/depts")
    public  Result AddController(@RequestBody dept deptin)
    {

        deptService.addService(deptin);

        logger.info("增加的部门是{}",deptin);
        return Result.suceess();

    }
    //这里是回显查询到的数据用于修改
    @GetMapping("/depts/{id}")
    public Result SelectNewController(@PathVariable Integer id)
    {

        logger.info("id是"+id);
        dept deptio = deptService.updateService(id);
        Result result=Result.suceess(deptio);
        return result;

    }
//修改操作,获得要修改的id，以及修改的信息
    @PutMapping("/depts")
    public Result MotifyController(@RequestBody dept deptin)
    {
        deptService.motifyService(deptin);

        return Result.suceess();

    }
    }

