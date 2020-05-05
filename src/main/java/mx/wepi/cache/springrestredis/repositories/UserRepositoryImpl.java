package mx.wepi.cache.springrestredis.repositories;

import java.util.Map;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import mx.wepi.cache.springrestredis.models.User;

@Repository
public class UserRepositoryImpl implements UserRepository {

	
	HashOperations<String, String, User> hashOperations;
	
	public UserRepositoryImpl(RedisTemplate<String, User> redisTemplate) {
		hashOperations = redisTemplate.opsForHash();
	}
	
	@Override
	public void save(User user) {
		hashOperations.put("ListUser", user.getId(), user);
	}

	@Override
	public void update(User user) {
		hashOperations.put("ListUser", user.getId(), user);
	}

	@Override
	public void delete(String id) {
		hashOperations.delete("ListUser", id);
	}

	@Override
	public User findById(String id) {
		return hashOperations.get("ListUser", id);
	}

	@Override
	public Map<String, User> findAll() {
		return hashOperations.entries("ListUser");
	}

}
