package com.safewind.model;

import javax.persistence.*;
import java.util.Date;

//import javax.persistence.Table;
//import java.time.DateTimeException;

/**
 * Created by lxy_x on 2018/2/27.
 */
@Table(name="system_book")
@Entity
public class Book {
   @Id
    @GeneratedValue
    private int bookId;
    @Column(nullable = false) private String bookName;
    private String bookStyle;
    @Column(nullable = false) private String bookAuthor;
    private String bookPub;
    private Date bookPubDate;
    @Column(nullable = false) private Date bookInDate;
    @Column(nullable = false) private String isBorrowed;

    public Book() {
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookStyle() {
        return bookStyle;
    }

    public void setBookStyle(String bookStyle) {
        this.bookStyle = bookStyle;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public String getBookPub() {
        return bookPub;
    }

    public void setBookPub(String bookPub) {
        this.bookPub = bookPub;
    }

    public Date getBookPubDate() {
        return bookPubDate;
    }

    public void setBookPubDate(Date bookPubDate) {
        this.bookPubDate = bookPubDate;
    }

    public Date getBookInDate() {
        return bookInDate;
    }

    public void setBookInDate(Date bookInDate) {
        this.bookInDate = bookInDate;
    }

    public String getIsBorrowed() {
        return isBorrowed;
    }

    public void setIsBorrowed(String isBorrowed) {
        this.isBorrowed = isBorrowed;
    }
}
