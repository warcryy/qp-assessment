package com.roles.assesement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.roles.assesement.dao.MasterUserDao;
import com.roles.assesement.entity.MasterGroceryItem;
import com.roles.assesement.entity.MasterOrderItems;
import com.roles.assesement.service.MasterUserManager;

@RestController
@RequestMapping("/User")
public class MasterUserController {

	@Autowired
	MasterUserDao masterUserDao;
	
    @Autowired
    MasterUserManager masterUserManager;

    //Get the list of grocery items who's inventory status is 0 means "Available"
    @GetMapping("/check_available_items")
    public ResponseEntity<Object> checkItems(@RequestHeader("roleId") String roleId) {
        try {
            if (!"2".equals(roleId)) {
                return new ResponseEntity<>("Not enough permission", HttpStatus.FORBIDDEN);
            }

            List<MasterGroceryItem> listOfAvailableItems = masterUserManager.findTheAvailableItems();
            return new ResponseEntity<>(listOfAvailableItems, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.print("Error occurred in MasterUserController :: checkItems " + e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
	
	//Book multiple groceries by sending a post request which takes the list of Master Order Items and updates in table
    @PostMapping("/book_grocery")
    public ResponseEntity<Object> bookGrocery(@RequestHeader("roleId") String roleId, @RequestBody List<MasterOrderItems> bookingItems) {
        try {
            if (!"2".equals(roleId)) {
                return new ResponseEntity<>("Not enough permission", HttpStatus.FORBIDDEN);
            }

            masterUserDao.saveAll(bookingItems);
            return new ResponseEntity<>("Successfully Added Items", HttpStatus.ACCEPTED);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.print("Error occurred in MasterUserController :: bookGrocery " + e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
