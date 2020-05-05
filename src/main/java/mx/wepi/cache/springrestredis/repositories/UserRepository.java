package mx.wepi.cache.springrestredis.repositories;

import java.util.Map;

import mx.wepi.cache.springrestredis.models.User;

public interface UserRepository {

	void save(User user);
	void update(User user);
	void delete(String id);
	User findById(String id);
	Map<String, User> findAll();
	
}
