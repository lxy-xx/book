package com.safewind.model;

import javax.persistence.*;

/**
 * Created by zhh on 2018/2/28.
 */
@Table(name="book_style")
@Entity
public class BookStyle {
    @Id
    @GeneratedValue
    private int bookStyleNum;
    @Column(nullable = false) private String bookStyle;
}
