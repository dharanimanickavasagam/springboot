package com.springboot.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

// @Repository
// An instance of this class, that spring must create to talk to repo
// 

@Repository
public interface SiteUserDao extends CrudRepository<SiteUser, Long> {

	public SiteUser findByEmail(String email);

}
