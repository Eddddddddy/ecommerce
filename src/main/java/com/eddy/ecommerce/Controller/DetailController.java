package com.eddy.ecommerce.Controller;

import com.eddy.ecommerce.bean.Buy;
import com.eddy.ecommerce.bean.Goods;
import com.eddy.ecommerce.mapper.BuyMapper;
import com.eddy.ecommerce.mapper.GoodsMapper;
import com.eddy.ecommerce.mapper.UsersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;

@Controller
public class DetailController {
    @Autowired(required = false)
    GoodsMapper goodsMapper;

    @Autowired(required = false)
    BuyMapper buyMapper;

    @Autowired(required = false)
    UsersMapper usersMapper;

    @GetMapping("/detail/{good}")
    public String detail(Model model, @PathVariable String good, HttpSession session) {
        Object user=session.getAttribute("loginUser");
        Goods getGood= goodsMapper.getDeptByName(good);
        Buy getBuy=null;
        getBuy=buyMapper.getDept(usersMapper.getDeptByName((String) user).getU_email(),good);
        if (getBuy!=null){
            model.addAttribute("buy","already");
        }else{
            model.addAttribute("buy","none");
        }
        model.addAttribute("good",getGood);
        return "detail";
    }
}