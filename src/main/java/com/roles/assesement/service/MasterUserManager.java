package com.roles.assesement.service;

import java.util.List;

import com.roles.assesement.entity.MasterGroceryItem;

public interface MasterUserManager {

	List<MasterGroceryItem> findTheAvailableItems() throws Exception;
}
