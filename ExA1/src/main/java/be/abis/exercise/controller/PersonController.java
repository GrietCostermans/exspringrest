package be.abis.exercise.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import be.abis.exercise.model.Person;
import be.abis.exercise.service.PersonService;

@RestController
@RequestMapping("persons")
public class PersonController {
	@Autowired
	PersonService personService;
	
	@GetMapping("{id}")
	public Person findPerson(@PathVariable("id") int id) {
		return personService.findPerson(id);
	}  //http://localhost:8084/exercise/api/persons/1
}