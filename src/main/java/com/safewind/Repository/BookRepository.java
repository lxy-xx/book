package com.safewind.Repository;

import com.safewind.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by zhh on 2018/2/28.
 */
public interface BookRepository extends JpaRepository<Book,Integer> {
}
