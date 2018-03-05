package com.safewind.Service;

import com.safewind.Dao.BookDao;
import com.safewind.Dao.ReaderDao;
import com.safewind.Dao.ReaderFeeDao;
import com.safewind.model.ReaderFee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by zhh on 2018/3/5.
 */
@Service
public class Fine {
    @Autowired
    ReaderFeeDao readerFeeDao;
    @Autowired
    BookDao bookDao;
    @Autowired
    ReaderDao readerDao;
    @Value("${Fee}")
    private int fee;

    public Fine() {
    }

    public void dealWith(int bookId, int readerId, Date borrowDate){
        ReaderFee readerFee = new ReaderFee();
        readerFee.setBookId(bookId);
        readerFee.setBookName(bookDao.findOne(bookId).getBookName());
        readerFee.setReaderId(readerId);
        readerFee.setReaderName(readerDao.findByReaderId(readerId).getReaderName());
        readerFee.setBorrowDate(borrowDate);
        readerFee.setBookFee(fee);
        readerFeeDao.save(readerFee);
        return ;

    }
}
