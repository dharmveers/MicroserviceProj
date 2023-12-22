package com.quize.services.Impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quize.entities.Quize;
import com.quize.repositories.QuizeRepository;
import com.quize.services.QuestionClient;
import com.quize.services.QuizeServices;

@Service
public class QuizeServicesImpl implements QuizeServices{

	private QuizeRepository repository;
	
	private QuestionClient client;	
	
	public QuizeServicesImpl(QuizeRepository repository, QuestionClient client) {
		this.repository = repository;
		this.client = client;
	}

	@Override
	public Quize addQuize(Quize quize) {
		return this.repository.save(quize);
	}

	@Override
	public List<Quize> getAllQuize() {
		List<Quize> quizes=this.repository.findAll();
		quizes.forEach(quize->{
			quize.setQuestions(this.client.getQuestionsOfQuize(quize.getId()));
		});
		return quizes;
	}

	@Override
	public Quize getQuize(Long id) {
		Quize quize=this.repository.findById(id).orElse(null);
		quize.setQuestions(client.getQuestionsOfQuize(quize.getId()));
		return quize;
	}

}	
