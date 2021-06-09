/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.project.app.services;

import io.project.app.domain.Account;

import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.project.app.repositories.AccountRepository;
import java.util.List;

/**
 *
 * @author root
 */
@Service
@Slf4j
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;
   
    public Optional<Account> registerAccount(Account registerRequest)  {
        Optional<Account> existingAccount = accountRepository.findByEmail(registerRequest.getEmail());
       
        if (!existingAccount.isPresent()) {
            final Account save1 = accountRepository.save(registerRequest);

            return Optional.ofNullable(save1);
        }
        return Optional.empty();
    }

    public Optional<Optional<Account>> findByMail(final String email) {
        return Optional.of(this.accountRepository.findByEmail(email));
    }

    public Optional<List<Account>> getAccounts() {
        return Optional.of(this.accountRepository.findAll());
    }
    
    public String deleteById(final String id) {
        if(id!=null) {
         accountRepository.deleteById(id); return "Usel deleted";
        }
        return "id is missed";
    }

}
