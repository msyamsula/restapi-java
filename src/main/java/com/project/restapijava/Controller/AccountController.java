package com.project.restapijava.Controller;

import java.util.List;


import com.project.restapijava.Model.AccountModel;
import com.project.restapijava.ReqBody.PostAccountReqBody;
import com.project.restapijava.Response.Success.AccountResp;
import com.project.restapijava.Service.AccountService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class AccountController {
    
    @Autowired
    private AccountService service;

    @GetMapping(value="/account/all")
    public List<AccountModel> findAll() {
        return service.findAll();
    }

    @GetMapping(value="/account")
    public AccountResp getById(@RequestParam Integer id) {
        AccountModel result = this.service.getById(id);
        // System.out.println("halo");
        AccountResp resp = new AccountResp();

        resp.setId(result.getId());
        resp.setPassword(result.getPassword());
        resp.setUsername(result.getUsername());

        return resp;
    }

    @GetMapping(value="/account/{name}")
    public List<AccountModel> getByName(@PathVariable String name) {
        return this.service.getByUsername(name);
    }

    @PostMapping(value = "/account")
    public String addAccount(@RequestBody PostAccountReqBody accountReq){
        AccountModel account = new AccountModel();
        account.setUsername(accountReq.username);
        account.setPassword(accountReq.password);

        return this.service.save(account);
    }

    @PutMapping(value = "/account")
    public String updateById(@RequestBody PostAccountReqBody accountReq, @RequestParam Integer id){
        AccountModel account = new AccountModel();
        account.setId(id);
        account.setUsername(accountReq.username);
        account.setPassword(accountReq.password);

        return this.service.updateByID(id, account);
    }

    @DeleteMapping(value = "/account")
    public String deleteById(@RequestParam Integer id){
        return this.service.deleteById(id);
    }


    

}
