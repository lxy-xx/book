package com.safewind.Dao;

import com.safewind.model.Reader;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by zhh on 2018/2/28.
 */
public interface ReaderDao extends JpaRepository<Reader,Integer> {
     List<Reader> findByReaderName(String name);
     Reader findByReaderNameAndPassword(String readerName,String password);
     Reader findByReaderId(int id);
//     void updateReaderNameAndReaderSexAndReaderType(Reader reader);
}
