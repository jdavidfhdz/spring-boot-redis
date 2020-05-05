package mx.wepi.cache.springrestredis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import mx.wepi.cache.springrestredis.models.User;

@SpringBootApplication
public class WepiApplication {

	@Bean
	JedisConnectionFactory jedisConnectionFactory() {	
		return new JedisConnectionFactory();
	}
	
	@Bean
	RedisTemplate<String, User> redisTemplate(){
		RedisTemplate<String, User> redisTemplate = new RedisTemplate<>();
		redisTemplate.setConnectionFactory(jedisConnectionFactory());
		return redisTemplate;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(WepiApplication.class, args);
	}

}
