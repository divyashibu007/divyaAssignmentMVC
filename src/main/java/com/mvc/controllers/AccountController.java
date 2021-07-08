package com.mvc.controllers;

import com.mvc.model.*;
import com.mvc.service.AccountRepository;
import com.mvc.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import com.mvc.model.User;

import java.util.List;
import java.util.NoSuchElementException;

@Controller
public class AccountController {
    @Autowired
    private AccountService accountService;
    @Autowired
    private AccountRepository accountRepository;

    @RequestMapping("/account_list")
    public String viewAccount(Model model) {
        List<Account> listAccounts = accountService.listAll();
        model.addAttribute("listAccounts", listAccounts);

        return "account_list";
    }
        @RequestMapping("/new_account")
        public String showNewAccountPage(Model model) {
            Account account = new Account();
            model.addAttribute("account", account);
          
            List<User> users = accountService.getAllUsers();
            model.addAttribute("users", users);

            return "new_account";
        }


    @PostMapping("/save_account")
    public String add(Account account) {
        accountService.save(account);
        return "account_create_success";
    }

    @GetMapping("/accounts/{id}")
    public ResponseEntity<Account> get(@PathVariable Integer id) {
        try {
            Account account = accountService.get(id);
            return new ResponseEntity<Account>(account, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Account>(HttpStatus.NOT_FOUND);
        }
    }
    @RequestMapping("/edit_account/{id}")
    public ModelAndView showEditAccountPage(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("edit_account");
        Account account = accountService.get(id);
        List<User> users = accountService.getAllUsers();
        mav.addObject("account", account);
        mav.addObject("users", users);
       


 
        return mav;
    }

    @PostMapping("/process_edit_account")
    public String updateAccount(@ModelAttribute("account") Account accountUpdates) {
        Account existAccount = accountService.get(accountUpdates.getId());
        existAccount.setType(accountUpdates.getType());
        existAccount.setAccName(accountUpdates.getAccName());
        existAccount.setBankName(accountUpdates.getBankName());
        existAccount.setAccNo(accountUpdates.getAccNo());
        existAccount.setAssignedTo(accountUpdates.getAssignedTo());
       
        accountService.save(existAccount);
        return "edit_account_success";
    }
    @RequestMapping("/delete_account/{id}")
    public String delete(@PathVariable Integer id) {
    	accountService.delete(id);
        return "redirect:/account_list";
    }



}
