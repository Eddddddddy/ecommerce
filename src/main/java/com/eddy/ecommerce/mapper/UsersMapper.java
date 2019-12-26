package com.eddy.ecommerce.mapper;

import com.eddy.ecommerce.bean.Users;
import org.apache.ibatis.annotations.*;

import java.util.Collection;
@Mapper
public interface UsersMapper {
    @Select("select * from users where u_email=#{email}")
    public Users getDeptByEmail(String email);

    @Select("select * from users where u_name=#{name}")
    public Users getDeptByName(String name);

    @Select("select * from users")
    public Collection<Users> getAll();

    @Delete("delete from users where u_email=#{email}")
    public int deleteDeptByEmail(String email);

    @Insert("insert into users(u_email,u_password,u_name) values(#{email},#{password},#{name})")
    public int insertDept(Users users);

    @Update("update users set u_password=#{password} where u_email=#{email}")
    public int updateDept(Users users);
}
