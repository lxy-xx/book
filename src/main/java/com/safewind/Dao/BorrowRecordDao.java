package com.safewind.Dao;

import com.safewind.model.BorrowRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

/**
 * Created by zhh on 2018/2/28.
 */

public interface BorrowRecordDao extends JpaRepository<BorrowRecord,BorrowRecord.BorrowRecordPK> {
    BorrowRecord findByReaderIdAndBookId(int readerId,int bookId);
    List<BorrowRecord> findAllByReaderId(int readerId);
}
