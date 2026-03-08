package com.newp.tliasproject.Mapper;

import com.newp.tliasproject.pojo.EmpExpr;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

import java.util.List;
@Mapper
public interface EmpExprMapper {


    void insearch(List<EmpExpr> empExpr);

}
