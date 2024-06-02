package com.roles.assesement.service;

import java.util.List;

import com.roles.assesement.entity.MasterGroceryItem;

public interface MasterAdminManager {
	void updateInventory(int inventory, int itemId) throws Exception;
	List<MasterGroceryItem> getAllInventoryItems() throws Exception;
}
