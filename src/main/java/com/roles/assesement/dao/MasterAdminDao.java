package com.roles.assesement.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.roles.assesement.entity.MasterGroceryItem;

import jakarta.transaction.Transactional;

public interface MasterAdminDao extends JpaRepository<MasterGroceryItem , Integer>{

	 @Modifying
	    @Transactional
	    @Query("UPDATE MasterGroceryItem m SET m.inventory = :inventory WHERE m.id = :itemId")
	    void updateInventory(@Param("inventory") int inventory, @Param("itemId") int itemId);
	 
	 @Query("from MasterGroceryItem m ")
	 List<MasterGroceryItem> getAllInventoryItems();
}
