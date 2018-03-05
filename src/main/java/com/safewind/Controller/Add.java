package com.safewind.Controller;

import com.safewind.Dao.BookDao;
import com.safewind.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by qt on 2018/3/5.
 */
@RestController
public class Add {
    @Autowired
    private BookDao bookDao;
    @PostMapping(value = "bookAdd")//图书入库
    public String bookAdd(Book book){
        if (bookDao.exists(book.getBookId())==false){
            bookDao.save(book);
            return "入库成功!";
        }else
            return "指定图书ID已存在，请检查！！";
    }
}
