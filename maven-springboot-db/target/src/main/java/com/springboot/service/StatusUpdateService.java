package com.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.springboot.model.StatusUpdate;
import com.springboot.model.StatusUpdateDao;

// @Service
// Way of talking to spring that this is a service and create an bean for it 
// 

@Service
public class StatusUpdateService {

	private StatusUpdateDao statusUpdateDao;
	private static final int PAGESIZE = 5;

	public StatusUpdateDao getStausUpdateDao() {
		return statusUpdateDao;
	}

	@Autowired
	public void setStausUpdateDao(StatusUpdateDao stausUpdateDao) {
		this.statusUpdateDao = stausUpdateDao;
	}

	public void save(StatusUpdate statusUpdate) {
		statusUpdateDao.save(statusUpdate);
	}

	public StatusUpdate getlatest() {
		return statusUpdateDao.findFirstByOrderByAddedDesc();
	}

	// Page - Spring Object
	// PageRequest - Request for a Page, pages start from zero, so subtract 1
	// from pageNumber
	// Sort.Direction.DESC - sort it descending by added

	public Page<StatusUpdate> getPage(int pageNumber) {
		PageRequest request = new PageRequest(pageNumber - 1, PAGESIZE,
				Sort.Direction.DESC, "added");

		return statusUpdateDao.findAll(request);
	}

	public void deleteStatus(Long id) {
		statusUpdateDao.delete(id);
	}

	public StatusUpdate getByID(Long id) {
		return statusUpdateDao.findOne(id);
	}
}
