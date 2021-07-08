package com.mvc.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvc.model.Account;
import com.mvc.model.User;
@Service
public class AccountService {

    private static final Logger logger = LoggerFactory.getLogger(AccountService.class);
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private UserRepository userRepository;
  

    public List<Account> listAll() {
        logger.debug("Get All Account successfully!");
        return accountRepository.findAll();
    }

    public void save(Account account) {
        logger.info("Account Saved successfully!");
        accountRepository.save(account);
    }

    public Account get(Integer id) {
        logger.debug("Get Accounts By Id success!");
        return accountRepository.findById(id).get();
    }

    public void delete(Integer id) {
        logger.debug("Account Deleted successfully!");
        accountRepository.deleteById(id);
    }


   
    public List<User> getAllUsers() {
        logger.debug("Get Account user list successfully!");
       return userRepository.findAll();
     }
}
