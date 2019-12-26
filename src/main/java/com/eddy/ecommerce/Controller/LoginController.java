package com.eddy.ecommerce.Controller;

import com.eddy.ecommerce.bean.Sellers;
import com.eddy.ecommerce.bean.Users;
import com.eddy.ecommerce.mapper.SellersMapper;
import com.eddy.ecommerce.mapper.UsersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginController {

    @Autowired(required = false)
    UsersMapper usersMapper;
    @Autowired(required = false)
    SellersMapper sellersMapper;

    Users users = null;
    Sellers sellers=null;

    @PostMapping(value = "/user/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Map<String, Object> map,
                        HttpSession session) {
        if (!StringUtils.isEmpty(username) && !StringUtils.isEmpty(password)) {
            users=usersMapper.getDeptByEmail(username);
            sellers=sellersMapper.getDeptByEmail(username);
            if (users != null) {
                if (users.getU_password().equals(password)) {
                    session.setAttribute("loginUser", users.getU_name());
                    return "redirect:/main.html";
                }
            }else if (sellers!=null){
                if (sellers.getS_password().equals(password)) {
                    session.setAttribute("loginUser", sellers.getS_name());
                    return "redirect:/admin.html";
                }
            }
        }
        map.put("msg", "用户名密码错误");
        return "Login";
    }

    @GetMapping("/logoff")
    public String logoff(HttpSession session){
        session.setAttribute("loginUser", null);
        return "redirect:/index.html";
    }
}
