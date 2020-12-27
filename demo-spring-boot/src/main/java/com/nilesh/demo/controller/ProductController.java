package com.nilesh.demo.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javax.websocket.server.PathParam;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nilesh.demo.exception.ProductNotFoundException;
import com.nilesh.demo.model.Product;

@RestController
public class ProductController {
	
	private Map<Integer, Product> productRepo = new HashMap<>();
	   
	   
	   @GetMapping("/getproducts")
	   public ResponseEntity<Object> getProducts() {
		   
		   return new ResponseEntity<Object>(productRepo, HttpStatus.OK);
		
	   }
	   
	   @GetMapping("/product/{id}")
	   public ResponseEntity<Object> getProduct(@PathParam("id") Integer id) {
		   
		   Product product=productRepo.get(id);
		   
		   return new ResponseEntity<Object>(product, HttpStatus.OK);
		
	   }
	   
	   @PutMapping(path = "/updateproduct/{id}")
	   public ResponseEntity<Object> updatePrduct(@PathParam("id") Integer id,@RequestBody Product product) {
		   
		   System.out.println(productRepo);
		   
		   System.out.println(productRepo.containsKey(id));
		   
		   if(productRepo.containsKey(id)) {
			   productRepo.remove(id);
			   productRepo.put(id, product);
			   HttpHeaders headers=new HttpHeaders();
			   headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
			   
			   return new ResponseEntity<Object>("Product Updated Successfully", HttpStatus.OK);
			   
			   
		   }
		   else {
			   throw new ProductNotFoundException();
		   }
		   
	   }
}
