package com.roles.assesement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.roles.assesement.dao.MasterAdminDao;
import com.roles.assesement.entity.MasterGroceryItem;

@Service
public class MasterAdminManagerImpl implements MasterAdminManager{

	@Autowired
	MasterAdminDao masterAdminDao;

	@Override
	public void updateInventory(int inventory, int itemId) throws Exception {
		// TODO Auto-generated method stub
		masterAdminDao.updateInventory(inventory, itemId);
		return;
	}

	@Override
	public List<MasterGroceryItem> getAllInventoryItems() throws Exception {
		// TODO Auto-generated method stub
		return masterAdminDao.getAllInventoryItems();
	}
	
	
	
}
