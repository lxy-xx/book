package com.safewind.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by zhh on 2018/2/28.
 */
@Table(name="reader_fee")
@Entity
public class ReaderFee {
    @Id
    @GeneratedValue
    private int bookId;
    @Column(nullable = false) private int readerId;
    @Column(nullable = false) private String readerName;
    @Column(nullable = false) private String bookName;
    @Column(nullable = false) private float bookFee;
    @Column(nullable = false) private Date borrowDate;

    public ReaderFee() {
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getReaderId() {
        return readerId;
    }

    public void setReaderId(int readerId) {
        this.readerId = readerId;
    }

    public String getReaderName() {
        return readerName;
    }

    public void setReaderName(String readerName) {
        this.readerName = readerName;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public float getBookFee() {
        return bookFee;
    }

    public void setBookFee(float bookFee) {
        this.bookFee = bookFee;
    }

    public Date getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(Date borrowDate) {
        this.borrowDate = borrowDate;
    }
}
