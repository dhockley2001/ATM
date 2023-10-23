package com.dhockley2001.atm.atm.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dhockley2001.atm.atm.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{
    
}
