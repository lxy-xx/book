package com.safewind.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by zhh on 2018/2/28.
 * 两个主键
 */
@Table(name="return_record")
@Entity
@IdClass(ReturnRecord.ReturnRecordPK.class)
public class ReturnRecord {
    @Id private String readerName;
    @Id private int readerId;
    @Column(nullable = false) private Date returnDate;

    public ReturnRecord() {
    }

    public String getReaderName() {
        return readerName;
    }

    public void setReaderName(String readerName) {
        this.readerName = readerName;
    }

    public int getReaderId() {
        return readerId;
    }

    public void setReaderId(int readerId) {
        this.readerId = readerId;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public static class ReturnRecordPK implements Serializable{
        @Column(nullable = false) private int readerId;
        @Column(length = 100,nullable = false) private String readerName;

        public ReturnRecordPK(int readerId, String readerName) {
            this.readerId = readerId;
            this.readerName = readerName;
        }

        public ReturnRecordPK() {
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
    }
}
