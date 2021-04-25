package com.athut.controller.admin;

import com.athut.pojo.User;
import com.athut.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import javax.servlet.http.HttpSession;

/**
 * @author yangwan
 * @create 2021-04-11 21:44
 */
@Controller
@RequestMapping("/admin")
public class LoginController {
@Autowired
    UserServiceImpl userService;

    @GetMapping()
    public String loginPage(){
        return "admin/blog-login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password,
                        HttpSession session,
                        RedirectAttributes attributes){
        User user = userService.checkUser(username, password);
        if (user != null){
            user.setPassword(null);
            session.setAttribute("user",user);
            return "admin/index_success";
        }
        //使用重定向后，model不能传导到页面
        else {
            attributes.addFlashAttribute("message","用户名或者密码输入错误");
            return "redirect:/admin";
        }
    }

    @GetMapping("/loginout")
    public String loginOut(HttpSession session){
        session.removeAttribute("user");
        return "redirect:/admin";
    }
}
