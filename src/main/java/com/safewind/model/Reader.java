package com.safewind.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by zhh on 2018/2/28.
 */
@Table(name="system_readers")
@Entity
public class Reader {
    @Id
    @GeneratedValue
    private int readerId;
    @Column(nullable = false) private String readerName;
    @Column(nullable = false) private String readerSex;
    private String readerType;
    private Date regDate;

    public Reader() {
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

    public String getReaderSex() {
        return readerSex;
    }

    public void setReaderSex(String readerSex) {
        this.readerSex = readerSex;
    }

    public String getReaderType() {
        return readerType;
    }

    public void setReaderType(String readerType) {
        this.readerType = readerType;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }
}