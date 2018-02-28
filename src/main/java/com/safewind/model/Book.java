package com.safewind.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.DateTimeException;
import java.util.Date;

/**
 * Created by lxy_x on 2018/2/27.
 */
@Table(name="system_book")
@Entity
public class Book {
    @Id
    @GeneratedValue
    private String bookId;
    private String bookName;
    private String bookStyle;
    private String bookAuthor;
    private String bookPub;
    private Date bookPubDate;
    private Date bookInDate;
    private String isBorrowed;

    public Book() {
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
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
