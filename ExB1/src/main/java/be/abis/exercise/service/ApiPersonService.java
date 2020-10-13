package be.abis.exercise.service;

import java.io.IOException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import be.abis.exercise.exception.PersonCanNotBeDeletedException;
import be.abis.exercise.model.Login;
import be.abis.exercise.model.Person;

@Service
public class ApiPersonService implements PersonService {

	@Autowired
	private RestTemplate restTemplate;
	private String baseUrl ="http://localhost:8085/exercise/api/persons";
			
		
	@Override
	public Person findPerson(String emailAddress, String passWord) {
		System.out.println("B1 ApiPersonService in findperson() "+emailAddress+passWord);
		Login login = new Login();
		login.setEmail(emailAddress);
		login.setPassword(passWord);
		System.out.println(login.getEmail()+" "+login.getPassword());
		Person p = restTemplate.postForObject(baseUrl+"/login",login,Person.class);
		return p;
	}
	
	@Override
	public Person findPerson(int id) {
		System.out.println("B1 ApiPersonService in findperson(int) "+id);
		Person p = restTemplate.getForObject(baseUrl+"/"+id,Person.class);
		return p;
	}
	
	
		
	
	@Override
	public ArrayList<Person> getAllPersons() {
		// TODO Auto-generated method stub
		return null;
	}

	
	@Override
	public void addPerson(Person p) throws IOException {
		System.out.println("B1 ApiPersonService in addPerson "+p);
		restTemplate.postForObject(baseUrl+"/",p,Person.class);			
	}

	@Override
	public void deletePerson(int id) throws PersonCanNotBeDeletedException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void changePassword(Person p, String newPswd) throws IOException {
		// TODO Auto-generated method stub
		
	}

	
	
}

