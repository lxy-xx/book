package com.safewind.Controller;

import com.safewind.Dao.BookDao;
import com.safewind.Dao.ManagerDao;
import com.safewind.Dao.ReaderDao;
import com.safewind.model.Book;
import com.safewind.model.Manager;
import com.safewind.model.Reader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by zhh on 2018/3/1.
 */
@RestController
public class Select {
    @Autowired
    private ReaderDao readerDao;
    @Autowired
    private ManagerDao managerDao;
    @Autowired
    private BookDao bookDao;

    @RequestMapping(value = "checkAllReader")//查询所有借阅者
    public List<Reader> checkAllReader() {
        List<Reader> readerList = readerDao.findAll();
        for (Reader reader : readerList) {
            reader.setPassword(null);
        }
        return readerList;
    }

    @RequestMapping(value = "checkAllManager")//查询所有管理员
    public List<Manager> checkAllManager() {
        List<Manager> managerList = managerDao.findAll();
        for (Manager manager : managerList) {
            manager.setPassword(null);
        }
        return managerList;
    }

    @PostMapping(value = "selectReader")
    public Reader selectReader(@RequestParam("id") int id) {
        Reader reader = readerDao.findByReaderId(id);
        reader.setPassword(null);
        return reader;
    }

    @PostMapping(value = "selectManager")
    public Manager selectManager(@RequestParam("id") int id) {
        Manager manager = managerDao.findByManagerId(id);
        manager.setPassword(null);
        return manager;
    }

    @PostMapping(value = "selectBook")
    public Book selectBook(@RequestParam("id") int id) {
        Book book = bookDao.findByBookId(id);
        return book;

    }

    @PostMapping(value = "selectAllBook")
    public List<Book> selectAllBook(){
        return bookDao.findAll();
    }
}
