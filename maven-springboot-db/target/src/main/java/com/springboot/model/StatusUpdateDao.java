package com.springboot.model;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

// CrudRepository - pass 2 parameters 
// 1) Type it has to Persist - StatusUpdate
// 2) Primary Key - It shout be non primitive type, it cannot be primitive types in Template parameters  
//
@Repository
public interface StatusUpdateDao extends
		PagingAndSortingRepository<StatusUpdate, Long> {

	// Spring data JPA will define these methods
	public StatusUpdate findFirstByOrderByAddedDesc();

	// deletes the corresponding statusupdate entity
	public void delete(Long id);

	public StatusUpdate findOne(Long id);

}
