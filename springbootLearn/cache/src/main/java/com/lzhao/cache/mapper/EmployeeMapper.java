package com.lzhao.cache.mapper;

import com.lzhao.cache.bean.Employee;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface EmployeeMapper {

    @Select("select * from employee where id=#{id}")
    Employee getEmployeeById(int id);

    @Update("update employee set lastName=#{lastName}, email=#{email}, gender=#{gender}, d_id=#{dId} where id=#{id}")
    void updateEmployee(Employee employee);

    @Delete("Delete from employee where id=#{id}")
    void deleteEmployeeById(int id);

    @Insert("Insert into employee(lastName, email, gender, d_id) values(#{lastName}, #{email}, #{gender}, #{dId})")
    void insertEmployee(Employee employee);

    @Select("Select * from employee where lastName=#{lastName}")
    Employee getEmployeeByLastName(String lastName);
}
