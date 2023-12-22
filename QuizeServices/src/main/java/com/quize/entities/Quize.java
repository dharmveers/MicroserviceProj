package com.quize.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Quize {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String title;
	
	transient List<Question> questions;

	//	public Long getId() {
//		return id;
//	}
//	public String getTitle() {
//		return title;
//	}
//	public void setId(Long id) {
//		this.id = id;
//	}
//	public void setTitle(String title) {
//		this.title = title;
//	}
//	
	
}
