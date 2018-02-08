package com.admin.client.service;


import com.admin.client.dao.AccountDao;
import com.admin.client.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AccountService {

    @Autowired
    private AccountDao accountDao;

    @Transactional
    public void update(Integer id,Double money){
        accountDao.updateAccount(id,money);
    }
    public Account find(Integer id){
        return accountDao.findById(id);
    }
}
