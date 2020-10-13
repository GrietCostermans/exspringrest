package be.abis.exercise.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import be.abis.exercise.exception.PersonCanNotBeDeletedException;
import be.abis.exercise.model.Login;
import be.abis.exercise.model.Person;
import be.abis.exercise.service.PersonService;

@RestController
@RequestMapping(path="persons") //ook in pom aangepast voor xml
public class PersonController {
	@Autowired
	PersonService personService;
	
	@GetMapping(path="{id}")
	public Person findPerson(@PathVariable("id") int id) {
		return personService.findPerson(id);
	}  // http://localhost:8085/exercise/api/persons/1
	
	@DeleteMapping("{id}")
	public void deletePerson(@PathVariable("id") int id) {
		try {
			personService.deletePerson(id);
		} catch (PersonCanNotBeDeletedException e) {
			e.printStackTrace();
		}
	}  // DELETE http://localhost:8085/exercise/api/persons/4
	
	@PostMapping(path="")
	public void addPerson(@RequestBody Person person) {
		try {
			personService.addPerson(person);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}  // POST http://localhost:8085/exercise/api/persons/ in postman met (aangepaste) copy van de body van de GET 
	
	@PutMapping(path="{id}")
	public void changePassword(@PathVariable("id") int id, @RequestBody Person person) {
		try {
			personService.changePassword(person, person.getPassword());
		} catch (IOException e) {
			e.printStackTrace();
		}
	} // PUT http://localhost:8085/exercise/api/persons/10 	
	
	@PostMapping("login")
	public Person findPersonWithLogin(@RequestBody Login login) {
		System.out.println("A2 PersonController findPersonWithLogin "+login.getEmail()+" "+login.getPassword());
		return personService.findPerson(login.getEmail(),login.getPassword());
	}  // POST http://localhost:8085/exercise/api/persons/login
	
	
		
	
}