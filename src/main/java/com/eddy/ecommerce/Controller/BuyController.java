package com.eddy.ecommerce.Controller;

import com.eddy.ecommerce.mapper.BuyMapper;
import com.eddy.ecommerce.mapper.GoodsMapper;
import com.eddy.ecommerce.mapper.UsersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;


@Controller
public class BuyController {
    @Autowired(required = false)
    BuyMapper buyMapper;

    @Autowired(required = false)
    UsersMapper usersMapper;

    @Autowired(required = false)
    GoodsMapper goodsMapper;

    @PostMapping("/buy/{good}")
    public String buy(@PathVariable String good, HttpSession session, HttpServletRequest request) throws UnsupportedEncodingException {
        Object user=session.getAttribute("loginUser");
        buyMapper.insertDept(usersMapper.getDeptByName((String) user).getU_email(),good,1);
        goodsMapper.soldByName(good);

        return "redirect:/detail/"+good;
    }
}