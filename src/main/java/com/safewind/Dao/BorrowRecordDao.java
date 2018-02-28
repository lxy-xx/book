package com.safewind.Dao;

import com.safewind.model.BorrowRecord;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by zhh on 2018/2/28.
 */

public interface BorrowRecordDao extends JpaRepository<BorrowRecord,BorrowRecord.BorrowRecordPK> {
}
