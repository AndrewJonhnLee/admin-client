package com.admin.client.dao;

import com.admin.client.model.Account;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AccountDao extends CrudRepository<Account, Integer> {

    Account findById(Integer id);

    @Modifying
    @Query("update Account u set u.money= ?2 where u.id =?1")
    int updateAccount(Integer id,Double money);
}
