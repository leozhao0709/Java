package com.lzhao.cache.mapper;

import com.lzhao.cache.bean.Department;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface DepartmentMapper {

    @Select("Select * from department where id=#{id}")
    Department getDepartmentById(int id);
}
