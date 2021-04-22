package com.project.restapijava.Service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;


import com.project.restapijava.Model.AccountModel;
import com.project.restapijava.Repository.AccountRepository;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    public EntityManager entityManager;

    @Autowired
    public AccountRepository repository;

    @Override
    @Transactional
    public List<AccountModel> getByUsername(String name) {
        
        TypedQuery<AccountModel> query = this.entityManager.createQuery("from AccountModel a where a.username=:u", AccountModel.class);
        query.setParameter("u", name);

        List<AccountModel> result = query.getResultList();

        return result;
    }

    @Override
    @Transactional
    public List<AccountModel> findAll() {
        return repository.findAll();
    }

    @Override
    @Transactional
    public AccountModel getById(Integer id) {
        return repository.getById(id);
    }

    @Override
    @Transactional
    public String save(AccountModel account) {
        repository.save(account);

        return "saved";
    }

    @Override
    @Transactional
    public String deleteById(Integer id) {
        repository.deleteById(id);
        return "deleted";
    }

    @Override
    @Transactional
    public String updateByID(Integer id, AccountModel newAccount) {
        AccountModel account = this.repository.getById(id);
        account.setId(id);
        account.setUsername(newAccount.getUsername());
        account.setPassword(newAccount.getPassword());
        
        this.repository.save(account);
        return "updated";
    }
    
}
