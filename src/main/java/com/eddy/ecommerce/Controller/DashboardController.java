package com.eddy.ecommerce.Controller;

import com.eddy.ecommerce.bean.BuyGoods;
import com.eddy.ecommerce.bean.Goods;
import com.eddy.ecommerce.bean.Users;
import com.eddy.ecommerce.mapper.BuyMapper;
import com.eddy.ecommerce.mapper.GoodsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collection;

@Controller
public class DashboardController {
    @Autowired(required = false)
    GoodsMapper goodsMapper;

    @Autowired(required = false)
    BuyMapper buyMapper;


    @GetMapping("/admin.html")
    public String list(Model model) {
//        Collection<Goods> goods= goodsMapper.getAll();
//        model.addAttribute("goods",goods);
        Collection<BuyGoods> buyGoods=goodsMapper.getGoodsBuy();
        model.addAttribute("goods",buyGoods);
        return "dashboard";
    }

    @PostMapping("/send/{good}/{email}")
    public String send(Model model, @PathVariable String good,@PathVariable String email) {
        buyMapper.updateStateByNameEmail(2,good,email);
        return "redirect:/admin.html";
    }
}
