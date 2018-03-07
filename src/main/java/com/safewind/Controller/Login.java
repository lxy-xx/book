package com.safewind.Controller;

import com.safewind.Service.InExistence;
import com.safewind.model.Manager;
import com.safewind.model.Reader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

/**
 * 返回null登录失败
 * 返回实例登录完成
 * Created by zhh on 2018/2/28.
 */
@Controller
public class Login {
    @Autowired
    InExistence inExistence;
    @PostMapping(value="login")
    public String login(@RequestParam("readerName") String name,
                        @RequestParam("password") String password,
                        HttpSession session, Model model){
        Manager manager =inExistence.managerExit(name,password);
        if(null!=manager) {
            session.setAttribute("manager",manager);
            return "bookBorrowed";
        }
        Reader reader =inExistence.exit(name,password);
        if(null==reader){
            model.addAttribute("sign","用户名或密码错误");
            return "login";
        }
        else {
            session.setAttribute("reader",reader);
            return "bookBorrowed";
        }
    }
}
