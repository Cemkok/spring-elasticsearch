package com.elasticsearch.demo.dao;


import java.util.List;

import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.elasticsearch.demo.entities.Person;

@Repository
public interface PersonRepository extends ElasticsearchRepository<Person, String>{
	
	@Query("{\"bool\": {\"must\": [{\"match\": {\"name\": \"?0\"}}]}}")
	List<Person> getByCustomQuery(String search);

	List<Person> findByNameLikeOrSurnameLike(String name, String surname);

}
