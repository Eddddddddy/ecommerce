package com.eddy.ecommerce.Controller;

import com.eddy.ecommerce.bean.Goods;
import com.eddy.ecommerce.mapper.GoodsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collection;
@Controller
public class ShowGoodsController {
    @Autowired(required = false)
    GoodsMapper goodsMapper;

    @GetMapping("/main.html")
    public String show(Model model) {
        Collection<Goods> goods= goodsMapper.getAll();
        model.addAttribute("goods",goods);

        return "showGoods";
    }
}
