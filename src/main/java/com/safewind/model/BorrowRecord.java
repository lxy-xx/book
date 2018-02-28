package com.safewind.model;

import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by zhh on 2018/2/28.
 * 两个主键
 */
@Table(name="borrow_record")
@Entity
@IdClass(BorrowRecord.BorrowRecordPK.class)
public class BorrowRecord {
    @Id private int readerId;
    @Id private int bookId;
    @Column(nullable = false) private Date borrowDate;

    public BorrowRecord() {
    }

    public int getReaderId() {
        return readerId;
    }

    public void setReaderId(int readerId) {
        this.readerId = readerId;
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

    public static class BorrowRecordPK implements Serializable{
       @Column(nullable = false) private int readerId;
       @Column(nullable = false) private int bookId;

        public BorrowRecordPK(int readerId, int bookId) {
            this.readerId = readerId;
            this.bookId = bookId;
        }

        public int getReaderId() {
            return readerId;
        }

        public void setReaderId(int readerId) {
            this.readerId = readerId;
        }

        public int getBookId() {
            return bookId;
        }

        public void setBookId(int bookId) {
            this.bookId = bookId;
        }
    }
}
