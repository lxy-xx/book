package com.safewind.Dao;

import com.safewind.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

/**
 * Created by zhh on 2018/2/28.
 */
public interface BookDao extends JpaRepository<Book,Integer> {
    Book findByBookId(int Id);
    @Query("update Book book set book.bookName=?1,book.bookStyle=?2,book.bookAuthor=?3,book.bookPub=?4 where book.bookId=?5")
    @Transactional
    @Modifying
    void updateBookInformation(String bookName,String bookStyle,String bookAuthor,String bookPub,int bookId);
}
