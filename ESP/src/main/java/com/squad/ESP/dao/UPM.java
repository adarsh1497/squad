package com.squad.ESP.dao;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.squad.ESP.beans.PrimarySecondary;


@Repository
@Transactional
public interface UPM extends CrudRepository<PrimarySecondary, Integer> {

}
