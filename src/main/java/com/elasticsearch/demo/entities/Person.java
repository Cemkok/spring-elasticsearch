package com.elasticsearch.demo.entities;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Document(indexName = "persons" )
@Data
@RequiredArgsConstructor
@ToString
@EqualsAndHashCode
public class Person {
	 
	@Id
	private String id;
	
	@Field(name="name" , type=FieldType.Text)
	private String name;
	@Field(name="surname" , type=FieldType.Text)
	private String surname;
	@Field(name="address", type=FieldType.Text)
	private String address;
	@Field(name="birth_date", type=FieldType.Date)
	private Date birthDate;
	
}
