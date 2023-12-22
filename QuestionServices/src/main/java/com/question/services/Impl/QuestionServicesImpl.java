package com.question.services.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.question.entities.Question;
import com.question.repositories.QuestionRepo;
import com.question.services.QuestionServices;

@Service
public class QuestionServicesImpl implements QuestionServices{
	
	@Autowired
	private QuestionRepo questionRepo;
	
	@Override
	public Question addQuestion(Question question) {
		
		return this.questionRepo.save(question);
	}

	@Override
	public Question getQuestion(Long id) {
		
		return this.questionRepo.findById(id).orElse(new Question());
	}

	@Override
	public List<Question> getAll() {
		
		return this.questionRepo.findAll();
	}

	@Override
	public List<Question> getQuestionsOfQuiz(Long quizeId) {
		
		return this.questionRepo.findByQuizeId(quizeId);
	}

}
