package com.safewind.Dao;

import com.safewind.model.Reader;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by zhh on 2018/2/28.
 */
public interface ReaderDao extends JpaRepository<Reader,Integer> {
     List<Reader> findByReaderName(String name);
     Reader findByReaderNameAndPassword(String readerName,String password);
     Reader findByReaderId(int id);
     @Query("update Reader reader set reader.readerName=?1,reader.readerSex=?2,reader.readerType=?3 where reader.readerId=?4")
     @Modifying
     @Transactional
     void updateReaderInformation(String readerName,String readerSex,String readerType,int readerId);
}
