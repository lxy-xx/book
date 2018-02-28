package com.safewind.Dao;

import com.safewind.model.ReturnRecord;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by zhh on 2018/2/28.
 */
public interface ReturnRecordDao extends JpaRepository<ReturnRecord,ReturnRecord.ReturnRecordPK>{
}
