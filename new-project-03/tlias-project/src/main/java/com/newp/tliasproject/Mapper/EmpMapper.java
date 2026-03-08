package com.newp.tliasproject.Mapper;

import com.newp.tliasproject.pojo.Emp;
import com.newp.tliasproject.pojo.EmpQueryParam;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDate;
import java.util.List;
@Mapper
public interface EmpMapper {
//
//    @Select("select count(*) from emp e left join dept d on dept_id=d.id")
//    public Long count();
//
//    @Select ("select e.*,d.name deptName from emp e left join dept d on e.dept_id=d.id order by e.update_time desc limit #{start},#{pageSize}")
//    public List<Emp> list (Integer start, Integer pageSize);



//   public List<Emp> list (String name, Integer gender ,LocalDate begin, LocalDate end);
public List<Emp> list (EmpQueryParam empQueryParam);
//    @Select(" select  e.*,d.name deptName from emp e left join dept d on e.dept_id=d.id where e.name like '%阮%' and e.gender=1 and e." +
//            "entry_date between '2010-01-01' and '2020-01-01' order by e.update_time desc ")
//public List<Emp>
    //获得生成的主键，mybatis自动把从中获得的主键返回到emp中
@Options(useGeneratedKeys = true,keyProperty = "id")
@Insert("insert into emp(username, name, gender, phone, job, salary, image, entry_date, dept_id, create_time, update_time) " +
        "values (#{username}, #{name}, #{gender}, #{phone}, #{job}, #{salary}, #{image}, #{entryDate}, #{deptId}, #{createTime}, #{updateTime})")
public void insert(Emp emp);




}
