package com.eddy.ecommerce.Controller;

import com.eddy.ecommerce.bean.BuyGoods;
import com.eddy.ecommerce.mapper.BuyMapper;
import com.eddy.ecommerce.mapper.GoodsMapper;
import com.eddy.ecommerce.mapper.UsersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.Collection;
@Controller
public class MyCenterController {
    @Autowired(required = false)
    GoodsMapper goodsMapper;

    @Autowired(required = false)
    BuyMapper buyMapper;

    @Autowired(required = false)
    UsersMapper usersMapper;

    @GetMapping("/mycenter")
    public String list(Model model, HttpSession session) {
//        Collection<Goods> goods= goodsMapper.getAll();
//        model.addAttribute("goods",goods);
        Object user=session.getAttribute("loginUser");
        Collection<BuyGoods> buyGoods=buyMapper.getBuyGoods(usersMapper.getDeptByName((String) user).getU_email());
        model.addAttribute("goods",buyGoods);
        return "myCenter";
    }

    @PostMapping("/confirm/{good}/{email}")
    public String send(Model model, @PathVariable String good, @PathVariable String email) {
        buyMapper.updateStateByNameEmail(0,good,email);
        return "redirect:/mycenter";
    }
}
