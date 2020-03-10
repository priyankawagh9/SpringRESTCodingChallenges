package com.example.rest.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.rest.model.Customer;
import com.example.rest.model.KeyValue;
import com.example.rest.service.DaoService;

/**
 * 
 * @author TA
 *
 */
@RestController
public class mainController {
	
	@Autowired
	DaoService daoService;
	
	@GetMapping("test")
	public String test()
	{
		return "Hello";
	}
	
	@GetMapping("customers")
	public Customer getCustomers()
	{
		List<String> hobbies = new ArrayList<>();
		hobbies.add("Swimming");
		hobbies.add("Playing");
		hobbies.add("Coding");
	
		return new Customer(10, "Amit", hobbies);
	}
	
	@GetMapping("getData")
	public KeyValue getData()
	{
		KeyValue keyValue = daoService.readFile();
		System.out.println(keyValue);
		return keyValue;
	}

}
