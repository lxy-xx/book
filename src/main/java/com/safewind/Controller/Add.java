package com.safewind.Controller;

import com.safewind.Dao.BookDao;
import com.safewind.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * Created by qt on 2018/3/5.
 */
@RestController
public class Add {
    @Autowired
    private BookDao bookDao;
    @PostMapping(value = "bookAdd")//图书入库
    public String bookAdd(Book book){
        book.setBookInDate(new Date());
        book.setIsBorrowed("未借");
        bookDao.save(book);
        return "入库成功!";

    }
}
