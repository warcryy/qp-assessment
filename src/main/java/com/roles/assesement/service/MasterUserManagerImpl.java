package com.roles.assesement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.roles.assesement.dao.MasterUserDao;
import com.roles.assesement.entity.MasterGroceryItem;

@Service
public class MasterUserManagerImpl implements MasterUserManager{

	
	@Autowired
	MasterUserDao masterUserDao;

	@Override
	public List<MasterGroceryItem> findTheAvailableItems() throws Exception {
		// TODO Auto-generated method stub
		return masterUserDao.findTheAvailableItems();
	}
	
	
}
