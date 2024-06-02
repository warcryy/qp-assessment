package com.roles.assesement.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.roles.assesement.entity.MasterGroceryItem;
import com.roles.assesement.entity.MasterOrderItems;


@Repository
public interface MasterUserDao extends JpaRepository<MasterOrderItems , Integer>{

	
	@Query("from MasterGroceryItem g where g.inventory = 0")
	List<MasterGroceryItem> findTheAvailableItems();
	
}
