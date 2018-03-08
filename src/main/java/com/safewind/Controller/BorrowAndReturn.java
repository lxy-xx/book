package com.safewind.Controller;

import com.safewind.Dao.BookDao;
import com.safewind.Dao.BorrowRecordDao;
import com.safewind.Dao.ReaderDao;
import com.safewind.Dao.ReturnRecordDao;
import com.safewind.Service.Fine;
import com.safewind.model.Book;
import com.safewind.model.BorrowRecord;
import com.safewind.model.Reader;
import com.safewind.model.ReturnRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * Created by zhh on 2018/3/5.
 */
@RestController
public class BorrowAndReturn {
    @Autowired private BorrowRecordDao borrowRecordDao;
    @Autowired private BookDao bookDao;
    @Autowired private ReturnRecordDao returnRecordDao;
    @Autowired private ReaderDao readerDao;
    @Autowired private Fine fine;
    @Value("${borderTime}")
    private long borderTime;
    @PostMapping(value="borrowBook")
    public String borrow(@RequestParam("bookId") int bookId,
                         HttpSession session ){
        int readerId = ((Reader)session.getAttribute("reader")).getReaderId();
        //添加借书记录
        BorrowRecord borrowRecord =new BorrowRecord();
        borrowRecord.setBookId(bookId);
        borrowRecord.setReaderId(readerId);
        borrowRecord.setBorrowDate(new Date());
        borrowRecordDao.save(borrowRecord);
        //更新图书借阅信息
        Book book = bookDao.findOne(bookId);
        book.setIsBorrowed("已借阅");
        bookDao.save(book);
        return "借阅成功";
    }
    @PostMapping(value="returnBook")
    public String returnBook(@RequestParam("bookId") int bookId,
                             HttpSession session ){
        int readerId = ((Reader)session.getAttribute("reader")).getReaderId();
        //添加还书记录
        ReturnRecord returnRecord = new ReturnRecord();
        returnRecord.setReaderId(bookId);
        returnRecord.setReaderName(readerDao.findByReaderId(readerId).getReaderName());
        returnRecord.setReturnDate(new Date());
        returnRecordDao.save(returnRecord);
        //更新借阅信息
        Book book = bookDao.findOne(bookId);
        book.setIsBorrowed("未借阅");
        bookDao.save(book);
        //是否罚款
        BorrowRecord borrowBefore;
        borrowBefore =  borrowRecordDao.findByReaderIdAndBookId(readerId,bookId);
        Date borrowDate=borrowBefore.getBorrowDate();
        Date returnDate=returnRecord.getReturnDate();
        long timeDifference=returnDate.getTime()-borrowDate.getTime();
        if(timeDifference>borderTime){
            fine.dealWith(bookId,readerId,borrowDate);
            return "逾期，已罚款！";
        }

        return "还书成功！";
    }
}
