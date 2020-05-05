package mx.wepi.cache.springrestredis.services;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.wepi.cache.springrestredis.models.User;
import mx.wepi.cache.springrestredis.repositories.UserRepository;

@RestController
@RequestMapping("/user")
public class UserService {

	UserRepository userRepository;
	
	public UserService (UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@GetMapping("/add/{id}/{name}/{city}")
	public User add(@PathVariable("id")final String id,
			@PathVariable("name")final String name,
			@PathVariable("city")final String city) {
		userRepository.save(new User(id, name, city));
		return userRepository.findById(id);
	}
	
	@GetMapping("/update/{id}/{name}/{city}")
	public User update(@PathVariable("id")final String id,
			@PathVariable("name")final String name,
			@PathVariable("city")final String city) {
		userRepository.update(new User(id, name, city));
		return userRepository.findById(id);
	}
	
	@GetMapping("/delete/{id}")
	public Map<String, User> delete(@PathVariable("id")final String id) {
		userRepository.delete(id);
		return userRepository.findAll();
	}
	
	@GetMapping("/all")
	public Map<String, User> all() {
		return userRepository.findAll();
	}
	
}
