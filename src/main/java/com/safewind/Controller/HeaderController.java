package com.safewind.Controller;

import com.safewind.model.Manager;
import com.safewind.model.Reader;
import org.omg.CORBA.Object;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * Created by lxy_x on 2018/3/7.
 */
@RestController
public class HeaderController {
    @RequestMapping(value = "header.js")
    public String header(HttpSession session){
        Manager manager = (Manager)session.getAttribute("manager");
        Reader reader = (Reader)session.getAttribute("reader");

        StringBuffer bf = new StringBuffer("document.write('<div style=\"height: 50px\"></div><nav class=\"navbar navbar-default navbar-fixed-top\" role=\"navigation\"><div class=\"container-fluid\"><div class=\"navbar-header\"><button type=\"button\" class=\"navbar-toggle\" data-toggle=\"collapse\" data-target=\"#example-navbar-collapse\"><span class=\"sr-only\">切换导航</span><span class=\"icon-bar\"></span><span class=\"icon-bar\"></span><span class=\"icon-bar\"></span></button><a class=\"navbar-brand\" href=\"./home.html\"><span class=\"glyphicon glyphicon-book\"></span> 图书管理系统</a></div><div class=\"collapse navbar-collapse\" id=\"example-navbar-collapse\"><ul class=\"nav navbar-nav\"><li class=\"active\"><a href=\"bookSelect.html\">图书查询</a></li>");
        if(reader!=null){
            bf.append("<li><a href=\"personal.html\">个人中心</a></li>");
            bf.append("</ul>");
            bf.append("<ul class=\"nav navbar-nav navbar-right\"><li><a href=\"logout\"><span class=\"glyphicon glyphicon-log-in\"></span> 注销</a></li></ul>");
        }else if(manager!=null) {
            bf.append("<li class=\"dropdown\"><a href=\"#\" class=\"dropdown-toggle\" data-toggle=\"dropdown\">图书管理 <b class=\"caret\"></b></a><ul class=\"dropdown-menu\"><li><a href=\"bookChangePre.html\">修改图书信息</a></li><li class=\"divider\"></li><li><a href=\"addBook.html\">图书入库</a></li></ul></li>");
            bf.append("<li class=\"dropdown\"><a href=\"#\" class=\"dropdown-toggle\" data-toggle=\"dropdown\">借阅者管理 <b class=\"caret\"></b></a><ul class=\"dropdown-menu\"><li><a href=\"clientChangePre.html\">查询借阅者信息</a></li><li class=\"divider\"></li><li><a href=\"addClient.html\">新增借阅者</a></li></ul></li>");
            bf.append("</ul>");
            bf.append("<ul class=\"nav navbar-nav navbar-right\"><li><a href=\"logout\"><span class=\"glyphicon glyphicon-log-in\"></span> 注销</a></li></ul>");
        }else{
            bf.append("</ul>");
        }

        if(reader==null&&manager==null) {
            bf.append("<ul class=\"nav navbar-nav navbar-right\"><li><a href=\"login.html\"><span class=\"glyphicon glyphicon-log-in\"></span> 登录</a></li><input id=\"flag\" type=\"hidden\" value=\"-1\"/></ul>");
        }
        bf.append("</div></div></nav>');");
        return bf.toString();
    }
}
