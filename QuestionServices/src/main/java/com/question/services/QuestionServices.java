package com.question.services;

import java.util.List;

import com.question.entities.Question;

public interface QuestionServices {
	
	//add question here
	public Question addQuestion(Question question);
	
	//get single question by id
	public Question getQuestion(Long id);
	
	//get all questions
	public List<Question> getAll();
	
	public List<Question> getQuestionsOfQuiz(Long quizeId);
}
