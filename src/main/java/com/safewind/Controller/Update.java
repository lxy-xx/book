package com.safewind.Controller;

import com.safewind.Dao.BookDao;
import com.safewind.Dao.ManagerDao;
import com.safewind.Dao.ReaderDao;
import com.safewind.Service.InExistence;
import com.safewind.model.Book;
import com.safewind.model.Manager;
import com.safewind.model.Reader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zhh on 2018/3/1.
 */
@RestController
public class Update {
    @Autowired private ReaderDao readerDao;
    @Autowired private ManagerDao managerDao;
    @Autowired
    InExistence inExistence;
    @Autowired private BookDao bookDao;
    @PostMapping(value="readerUpdate")
    public String readerUpdate(Reader reader){
        if(true==inExistence.readerExist(reader.getReaderId())) {
            readerDao.save(reader);
            return "修改成功！";//修改成功后的页面
        }else
            return "修改失败！请检查信息！";//修改失败后的页面
    }
    @PostMapping(value="managerUpdate")
    public String managerUpdate(Manager manager){
        if(false==inExistence.managerExist(manager.getManagerId())){
            managerDao.save(manager);
            return "修改成功！";//修改成功后的页面
        }else
            return "修改失败！请检查信息！";//修改失败后的页面
    }
    @PostMapping(value = "bookUpdate") //修改图书信息
    public  String bookUpdate(Book book){
        if (true==bookDao.exists(book.getBookId())){
            bookDao.save(book);
            return "修改成功";
        }else
            return "修改失败！此书不存在！请检查！";

    }
}
