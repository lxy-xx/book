package com.safewind.Dao;

import com.safewind.model.Manager;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by zhh on 2018/2/28.
 */
public interface ManagerDao extends JpaRepository<Manager,Integer> {
    Manager findByManagerId(int Id);
}
