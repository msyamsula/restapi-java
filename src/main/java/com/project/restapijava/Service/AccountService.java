package com.project.restapijava.Service;

import java.util.List;

import com.project.restapijava.Model.AccountModel;

public interface AccountService {
    public List<AccountModel> getByUsername(String name);
    public AccountModel getById(Integer id);
    public List<AccountModel> findAll();
    public String deleteById(Integer id);
    public String save(AccountModel account);
    public String updateByID(Integer id, AccountModel newAccount);
}
