package com.quize.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quize.entities.Quize;
import com.quize.services.QuizeServices;

@RestController
@RequestMapping("/quiz")
public class QuizeController {
	
	@Autowired
	private QuizeServices quizeServices;
	
	@PostMapping
	public Quize addQuize(@RequestBody Quize quize) {
			System.out.println(quize.getTitle());
		return this.quizeServices.addQuize(quize); 
	}
	
	@GetMapping
	public List<Quize> getAll(){
		System.out.println("Dharam");
		return this.quizeServices.getAllQuize();
	}
	
	@GetMapping("/{id}")
	public Quize getQuize(@PathVariable Long id) {
		return this.quizeServices.getQuize(id);
	}
}
