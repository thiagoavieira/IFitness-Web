package br.edu.ifsp.arq.dw2s6.ifitness.resource;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifsp.arq.dw2s6.ifitness.domain.model.Gender;
import br.edu.ifsp.arq.dw2s6.ifitness.domain.model.User;
import br.edu.ifsp.arq.dw2s6.ifitness.repository.UserRepository;

@RestController
@RequestMapping("/users")
public class UserResource {
	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping
	public List<User> list(){
		return userRepository.findAll();
	}
	
}
