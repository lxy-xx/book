package com.safewind.Service;

import com.safewind.Dao.ManagerDao;
import com.safewind.Dao.ReaderDao;
import com.safewind.model.Manager;
import com.safewind.model.Reader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zhh on 2018/2/28.
 * 返回true可以注册
 */
@Service
public class InExistence {
    @Autowired
    ReaderDao readerDao;
    @Autowired
    ManagerDao managerDao;
    public boolean exit(String name){
        List readerList = readerDao.findByReaderName(name);
        if(0!=readerList.size())
            return false;
        else
            return true;
    }

    /**
     * 返回true可以修改
     * @param Id
     * @return
     */
    public boolean readerExit(int Id){
        Reader reader=null;
        reader=readerDao.findByReaderId(Id);
        if(null==reader)
            return false;
        else
            return true;
    }

    /**
     *返回null账号密码错误
     * @param name
     * @param password
     * @return
     */
    public Reader exit(String name,String password){
        Reader reader = readerDao.findByReaderNameAndPassword(name,password);
        if(null==reader)
            return null;
        else
            return reader;
    }

    /**
     * 返回true可以注册
     * @param Id
     * @return
     */
    public boolean managerExit(int Id){
        Manager manager = null;
        manager=managerDao.findByManagerId(Id);
        if(null!=manager)
            return false;
        else
            return true;
    }
}