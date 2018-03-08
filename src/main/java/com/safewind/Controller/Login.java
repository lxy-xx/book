package com.safewind.Controller;

import com.safewind.Service.InExistence;
import com.safewind.model.Manager;
import com.safewind.model.Reader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * 返回null登录失败
 * 返回实例登录完成
 * Created by zhh on 2018/2/28.
 */
@RestController
public class Login {
    @Autowired
    InExistence inExistence;
    @PostMapping(value="loginDo")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        HttpSession session){
        Manager manager =inExistence.managerExit(username,password);
        if(null!=manager) {
            session.setAttribute("manager",manager);
            return "home.html";
        }
        Reader reader =inExistence.exit(username,password);
        if(null==reader){

            return "-1";
        }
        else {
            session.setAttribute("reader",reader);
            return "personal.html";
        }
    }

    @RequestMapping(value="logout")
    public String logout(HttpSession session){
        session.removeAttribute("reader");
        session.removeAttribute("manager");

        return "<script>window.location.href = 'home.html';</script>";

    }
}
