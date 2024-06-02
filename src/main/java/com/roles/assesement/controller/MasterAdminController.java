package com.roles.assesement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.roles.assesement.dao.MasterAdminDao;
import com.roles.assesement.entity.MasterGroceryItem;
import com.roles.assesement.service.MasterAdminManager;

@RestController
@RequestMapping("/Admin")
public class MasterAdminController {

	@Autowired
	MasterAdminDao masterAdminDao;
	
	@Autowired
	MasterAdminManager masterAdminManager;
	
     //Admin controller describes the required action by the "Admin" role.
	
	//Sends a post request to add grocery items in the grocery_item table
	@PostMapping("/add_grocery_item")
	public ResponseEntity<Object> addItems(@RequestHeader("roleId") String roleId , @RequestBody MasterGroceryItem masterGroceryItem){
		
		try {
			if(!"1".equals(roleId)) {
				return new ResponseEntity<>("Not enough permission", HttpStatus.FORBIDDEN);
			}else {
				masterAdminDao.save(masterGroceryItem);
				
				return new ResponseEntity<>("Successfully Added", HttpStatus.ACCEPTED);
			}
		}catch(Exception e) {
			e.printStackTrace();
			 System.out.print("Error occurred in MasterAdminController :: addItems " + e.getMessage());
	            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	//get the list of all grocery item from the table
	@GetMapping("/get_item_list")
	public ResponseEntity<Object> viewAllItems(@RequestHeader("roleId") String roleId){
		
		try {
			if(!"1".equals(roleId)) {
				return new ResponseEntity<>("Not enough permission", HttpStatus.FORBIDDEN);
			}else {
			
				List<MasterGroceryItem> listOfGroceryItem = masterAdminManager.getAllInventoryItems();
				return new ResponseEntity<>(listOfGroceryItem, HttpStatus.ACCEPTED);
			}
		}catch(Exception e) {
			e.printStackTrace();
			 System.out.print("Error occurred in MasterAdminController :: viewAllItems " + e.getMessage());
	            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	//delete grocery items from table by their primary key
	@DeleteMapping("/delete/{id}")
	public  ResponseEntity<Object> deleteItem(@RequestHeader("roleId") String roleId,@PathVariable("id") int id){
		
		try {
			if(!"1".equals(roleId)) {
				return new ResponseEntity<>("Not enough permission", HttpStatus.FORBIDDEN);
			}else {
				masterAdminDao.deleteById(id);
				return new ResponseEntity<>("Successfully Deleted !", HttpStatus.ACCEPTED);
				
			}
		}catch(Exception e) {
			e.printStackTrace();
			 System.out.print("Error occurred in MasterAdminController :: deleteItem " + e.getMessage());
	            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	//update grocery items in the table by primary key
	@PutMapping("/update_grocery_item")
	public ResponseEntity<Object> updateItems(@RequestHeader("roleId") String roleId , @RequestBody MasterGroceryItem masterGroceryItem){
		
		try {
			if(!"1".equals(roleId)) {
				return new ResponseEntity<>("Not enough permission", HttpStatus.FORBIDDEN);
			}else {
				masterAdminDao.save(masterGroceryItem);
				
				return new ResponseEntity<>("Successfully Updated", HttpStatus.ACCEPTED);
			}
		}catch(Exception e) {
			e.printStackTrace();
			 System.out.print("Error occurred in MasterAdminController :: updateItems " + e.getMessage());
	            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	//update inventory status by the primary key . If inventory status is 0 it means the item is "Available" if its 1 then the item is not available.
	@PostMapping("/update_inventory_status")
	public ResponseEntity<Object> updateInventoryStatus(@RequestHeader("roleId") String roleId , @RequestParam("id") int itemId , @RequestParam("inventory") int statusInventory){
		
		try {
			if(!"1".equals(roleId)) {
				return new ResponseEntity<>("Not enough permission", HttpStatus.FORBIDDEN);
			}else {
				masterAdminManager.updateInventory(statusInventory, itemId);
				
				return new ResponseEntity<>("Successfully Status Changed !", HttpStatus.ACCEPTED);
			}
		}catch(Exception e) {
			e.printStackTrace();
			 System.out.print("Error occurred in MasterAdminController :: updateInventoryStatus " + e.getMessage());
	            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
 }
