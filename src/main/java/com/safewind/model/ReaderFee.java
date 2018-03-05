package com.safewind.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by zhh on 2018/2/28.
 */
@Table(name="reader_fee")
@Entity
@IdClass(ReaderFee.ReaderFeePK.class)
public class ReaderFee {
    @Id private Date borrowDate;
    @Id private int bookId;
    @Column(nullable = false) private int readerId;
    @Column(nullable = false) private String readerName;
    @Column(nullable = false) private String bookName;
    @Column(nullable = false) private int bookFee;


    public static class ReaderFeePK implements Serializable{
        @Column(nullable = false) private int bookId;
        @Column(nullable=false) private Date borrowDate;

        public ReaderFeePK(int bookId, Date borrowDate) {
            this.bookId = bookId;
            this.borrowDate = borrowDate;
        }

        public int getBookId() {
            return bookId;
        }

        public void setBookId(int bookId) {
            this.bookId = bookId;
        }

        public Date getBorrowDate() {
            return borrowDate;
        }

        public void setBorrowDate(Date borrowDate) {
            this.borrowDate = borrowDate;
        }
    }

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

    public int getBookFee() {
        return bookFee;
    }

    public void setBookFee(int bookFee) {
        this.bookFee = bookFee;
    }

    public Date getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(Date borrowDate) {
        this.borrowDate = borrowDate;
    }
}
