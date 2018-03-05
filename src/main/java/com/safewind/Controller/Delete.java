package com.safewind.Controller;

import com.safewind.Dao.BookDao;
import com.safewind.Dao.ManagerDao;
import com.safewind.Dao.ReaderDao;
import com.safewind.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zhh on 2018/3/1.
 */
@RestController
public class Delete {
    @Autowired private ReaderDao readerDao;
    @Autowired private ManagerDao managerDao;
    @Autowired private BookDao bookDao;
    @GetMapping(value = "readerDelete")
    public String readerDelete(@RequestParam("readerId")int readerId){
        readerDao.delete(readerId);
        return "删除成功！";//成功删除后跳转界面
    }
    @GetMapping(value="managerDelete")
    public String managerDelete(@RequestParam("managerId")int managerId){
        managerDao.delete(managerId);
        return "删除成功！";//成功删除后的界面
    }
    @GetMapping(value = "bookDelete")
    public String bookDelete(@RequestParam("bookId") int bookId){
        bookDao.delete(bookId);
        return "删除成功";
    }
}
