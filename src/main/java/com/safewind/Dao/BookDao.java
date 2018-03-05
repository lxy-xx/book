package com.safewind.Dao;

import com.safewind.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by zhh on 2018/2/28.
 */
public interface BookDao extends JpaRepository<Book,Integer> {
    Book findByBookID(int ID);
}
