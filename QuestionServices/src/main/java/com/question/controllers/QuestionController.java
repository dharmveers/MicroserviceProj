package com.question.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.question.entities.Question;
import com.question.services.QuestionServices;

@RestController
@RequestMapping("/question")
public class QuestionController {
	
	@Autowired
	private QuestionServices services;
	
	@PostMapping
	public Question addQuestion(@RequestBody Question question) {
		
		return this.services.addQuestion(question);
	}
	
	@GetMapping("/{id}")
	public Question getQuestion(@PathVariable Long id) {
		
		return this.services.getQuestion(id);
	}
	
	@GetMapping
	public List<Question> getAll(){
		
		return this.services.getAll();
	}
	
	//get all question of specified quize
	
	@GetMapping("/quiz/{quizId}")
	public List<Question> getQuestionsOfQuiz(@PathVariable Long quizId){

		return this.services.getQuestionsOfQuiz(quizId);
	}
}
