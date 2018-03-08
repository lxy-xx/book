package com.safewind.Service;

import com.safewind.Dao.BookDao;
import com.safewind.Dao.BorrowRecordDao;
import com.safewind.model.Book;
import com.safewind.model.BorrowRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhh on 2018/3/8.
 */
@Service
public class BorrowMethod {
    @Autowired
    BorrowRecordDao borrowRecordDao;
    @Autowired
    BookDao bookDao;
    public List<Book> returnMyBooks(int readerId){
        List<BorrowRecord> borrowRecordList = borrowRecordDao.findAllByReaderId(readerId);
        List bookList = new ArrayList<Book>();
        int bookId;
        for(BorrowRecord borrowRecord :borrowRecordList){
            bookId=borrowRecord.getBookId();
            bookList.add(bookDao.findByBookId(bookId));
        }
        return bookList;
    }
}
