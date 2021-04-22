package com.project.restapijava.Repository;

import com.project.restapijava.Model.AccountModel;

import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.stereotype.Repository;

public interface AccountRepository extends JpaRepository<AccountModel, Integer> {
    
}
