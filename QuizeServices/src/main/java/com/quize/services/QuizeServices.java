package com.quize.services;

import java.util.List;

import com.quize.entities.Quize;

public interface QuizeServices{
	//add quize
	public Quize addQuize(Quize quize);
	
	//get all quize
	public List<Quize> getAllQuize();
	
	//get single quize
	public Quize getQuize(Long id);
}
