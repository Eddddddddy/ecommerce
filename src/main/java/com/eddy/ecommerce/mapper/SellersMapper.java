package com.eddy.ecommerce.mapper;

import com.eddy.ecommerce.bean.Sellers;
import org.apache.ibatis.annotations.*;

import java.util.Collection;
@Mapper
public interface SellersMapper {
    @Select("select * from sellers where s_email=#{email}")
    public Sellers getDeptByEmail(String email);

    @Select("select * from sellers")
    public Collection<Sellers> getAll();

    @Delete("delete from sellers where s_email=#{email}")
    public int deleteDeptByEmail(String email);

    @Insert("insert into sellers(s_email,s_password,s_name) values(#{email},#{password},#{name})")
    public int insertDept(Sellers sellers);

    @Update("update sellers set s_password=#{password} where s_email=#{email}")
    public int updateDept(Sellers sellers);
}
