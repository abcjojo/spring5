package com.atguigu.spring5.service;

import com.atguigu.spring5.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
/**
 *  propagation: 事务的传播行为 -- 多事务方法之间调用的行为  required和required_new 用的最多  spring 默认为 required
 *
 *  ioslation: 隔离级别 --  mysql 默认可重复读
 *
 *  timeout： 超时时间  默认-1-不超时
 *
 *  readOnly：是否只读
 *
 *  rollbackFor：回滚
 *
 *  noRollbackFor：不回滚
 */
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.REPEATABLE_READ)
public class UserService {

    @Autowired
    private UserDao userDao;

    public void accountMoney() {
        userDao.addMoney();
        userDao.reduceMoney();
    }
}
