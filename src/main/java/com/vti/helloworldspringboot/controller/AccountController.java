package com.vti.helloworldspringboot.controller;

import com.vti.helloworldspringboot.modal.dto.AccountCreateRequest;
import com.vti.helloworldspringboot.modal.dto.AccountUpdateRequest;
import com.vti.helloworldspringboot.modal.entity.Account;
import com.vti.helloworldspringboot.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("api/v1/account")
public class AccountController {
    @Autowired
    private IAccountService accountService;

    @GetMapping
    public List<Account> getAll(){

        return accountService.getAll();
    }

    @GetMapping("/get-all-v2")
    public Page<Account> getAllV2(@RequestParam int page,@RequestParam int size){
        return accountService.getAllV2(page, size);
    }

    @GetMapping("/{id}")
    public Account findById(@PathVariable long id){
        return accountService.findById(id);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable long id){
        try{
            accountService.delete(id);
            return "Đã xóa thành công!";
        } catch (Exception e) {
            return e.getMessage();
        }

    }

    @PostMapping("/create")
    public  Account create(@RequestBody AccountCreateRequest request){

        return accountService.create(request);
    }

    @PutMapping("/update")
    public  Account update(@RequestBody AccountUpdateRequest request){

        return accountService.update(request);
    }

}
