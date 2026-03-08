package com.newp.tliasproject.Mapper;

import com.newp.tliasproject.pojo.dept;
import org.apache.ibatis.annotations.*;

import java.util.List;
@Mapper
//既可以使用手动映射，也可以直接起别名
//使用驼峰命名的规则进行,针对字段名与属性名不一致
public interface DeptMapper {
//    @Select(" select id,name,create_time createTime ,update_Time updateTime from dept order by update_Time desc")
@Select(" select id,name,create_time  ,update_Time  from dept order by update_Time desc")
//删除部门
    public List<dept> selectAllMapper();
@Delete("delete from dept where id=#{id}")
    public void deleteMapper(Integer id);
//这里如果是多个占位符，也不需要考虑是否在编译后导致形参不一致，只要传来的参数名和这里的sql中一致即可
    //增加部门，可以把传入的dept
    @Insert("insert into dept (name,create_time ,update_Time)  values (#{name},#{createTime},#{updateTime})")
    public void  AddMapper(dept deptin);
    //根据id来选择需要返回的数据
    @Select("select * from dept where id=#{id}")
    public   dept  selectMapperById(Integer id);
    @Update("update dept set name=#{name},update_time=#{updateTime} where id=#{id}")
    public void modifyMapper(dept deptin);


    }
