package com.squad.ESP.dao;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.squad.ESP.beans.User;

@Transactional
@Repository
public interface UserRepo extends CrudRepository<User, String>{

}
