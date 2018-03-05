package com.safewind.Controller;

import com.safewind.Dao.ManagerDao;
import com.safewind.Dao.ReaderDao;
import com.safewind.Service.InExistence;
import com.safewind.model.Manager;
import com.safewind.model.Reader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zhh on 2018/2/28.
 */
@RestController
public class Register {
    @Autowired
    ReaderDao readerDao;
    @Autowired
    ManagerDao managerDao;
    @Autowired
    InExistence inExistence;
    @PostMapping(value = "readerRegister")//新增借阅者
    public String readerRegister(Reader reader){
      if(false==inExistence.exist(reader.getReaderName()))
          return "该用户已经存在！";//失败界面
      else{
          readerDao.save(reader);
          return "已成功！";//成功界面
      }
    }
    @PostMapping(value="managerRegister")//新增管理员
    public String managerRegister(Manager manager){
        if(false==inExistence.managerExist(manager.getManagerId()))
            return "";//失败界面
        else {
            managerDao.save(manager);
            return "";//成功界面
        }
    }
}
