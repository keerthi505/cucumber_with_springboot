package com.keerthi.cucumberrestapi.service;

import com.keerthi.cucumberrestapi.model.Account;
import com.keerthi.cucumberrestapi.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public Long saveAccount(Account account){
        return accountRepository.save(account).getId();
    }

    public Account getAccount(Long id){
        return accountRepository.findById(id).orElse(null);
    }
}
