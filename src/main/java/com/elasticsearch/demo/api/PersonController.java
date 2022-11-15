package com.elasticsearch.demo.api;

import java.util.Calendar;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.elasticsearch.demo.dao.PersonRepository;
import com.elasticsearch.demo.entities.Person;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/person")
public class PersonController {
	
	private final PersonRepository personRepository;
	
	
	@PostConstruct
	public void init() {
		Person person = new Person();
		person.setName("cem");
		person.setSurname("kok");
		person.setAddress("tübitak");
		person.setBirthDate(Calendar.getInstance().getTime());
		person.setId("K0001");
		personRepository.save(person);
			
	}
	
	
	@GetMapping("/{search}")
	public ResponseEntity<List<Person>> getPersonWithQueryAnnotation(@PathVariable String search){
		
		List<Person> persons =personRepository.getByCustomQuery(search);
		
		return ResponseEntity.ok(persons);
		
	}
	
	@GetMapping("/search2/{search}")
	public ResponseEntity<List<Person>> getPersonByNameOrSurname(@PathVariable String search){
		
		List<Person> persons =personRepository.findByNameLikeOrSurnameLike(search, search);
		
		return ResponseEntity.ok(persons);
		
	}
	

}
