package com.quize.services;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.quize.entities.Question;

//@FeignClient(url = "http://localhost:8082",value = "Q-Client")
@FeignClient(name="QUESTION-SERVICE")
public interface QuestionClient {
	
	@GetMapping("/question/quiz/{id}")
	List<Question> getQuestionsOfQuize(@PathVariable Long id);
}
