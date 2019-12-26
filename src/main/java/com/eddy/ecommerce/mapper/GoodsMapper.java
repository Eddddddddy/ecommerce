package com.eddy.ecommerce.mapper;

import com.eddy.ecommerce.bean.BuyGoods;
import com.eddy.ecommerce.bean.Goods;
import org.apache.ibatis.annotations.*;

import java.util.Collection;

@Mapper
public interface GoodsMapper {
    @Select("select * from goods where g_name=#{name}")
    public Goods getDeptByName(String name);

    @Select("select * from goods")
    public Collection<Goods> getAll();

    @Delete("delete from goods where g_name=#{name}")
    public int deleteDeptByName(String name);

    @Insert("insert into goods(g_name,g_description,g_price,g_inventory,g_more,g_detail,g_state) values(#{name},#{description},#{price},#{inventory},#{more},#{detail},#{state})")
    public int insertDept(Goods goods);

    @Update("update goods set g_inventory=#{inventory} where g_name=#{name}")
    public int updateDept(Goods goods);

    @Update("update goods set g_inventory=g_inventory-1 where g_name=#{name}")
    public int soldByName(String name);

    @Update("update goods set g_state=#{state} where g_name=#{name}")
    public int updateStateByName(int state,String name);

    @Select("select * from goods left join buy on goods.g_name = buy.b_name")
    public Collection<BuyGoods> getGoodsBuy();
}
