package br.edu.ifsp.arq.dw2s6.ifitness.resource;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifsp.arq.dw2s6.ifitness.domain.model.Gender;
import br.edu.ifsp.arq.dw2s6.ifitness.domain.model.User;

@RestController
public class UserController {
	
	@GetMapping("/users")
	public List<User> list(){
		// User list
		var user1 = new User();
		user1.setId(1L);
		user1.setName("Thiago Vieira");
		user1.setEmail("thiago.vmatos@hotmail.com");
		user1.setPassword("dw2s6");
		user1.setAge(21);
		user1.setGender(Gender.MASCULINO);
		
		var user2 = new User();
		user2.setId(2L);
		user2.setName("Luan Freitas");
		user2.setEmail("luanzinhopeixao2003@gmail.com");
		user2.setPassword("peleeterno");
		user2.setAge(20);
		user2.setGender(Gender.MASCULINO);
		
		return Arrays.asList(user1, user2);
	}
	
}
