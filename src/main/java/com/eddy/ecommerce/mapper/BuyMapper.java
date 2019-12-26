package com.eddy.ecommerce.mapper;

import com.eddy.ecommerce.bean.Buy;
import com.eddy.ecommerce.bean.BuyGoods;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.Collection;

@Mapper
public interface BuyMapper {
    @Insert("insert into buy(b_email,b_name,b_state) values(#{email},#{name},#{state})")
    public int insertDept(String email,String name,int state);

    @Select("select * from buy where b_email=#{email} and b_name=#{name}")
    public Buy getDept(String email, String name);

    @Update("update buy set b_state=#{state} where b_name=#{name} and b_email=#{email}")
    public int updateStateByNameEmail(int state,String name,String email);

    @Update("update buy set b_state=#{state} where b_email=#{email}")
    public int updateStateByEmail(int state,String email);

    @Select("select * from buy left join goods on buy.b_name= goods.g_name WHERE b_email = #{email}")
    public Collection<BuyGoods> getBuyGoods(String email);
}
