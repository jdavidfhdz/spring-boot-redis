package mx.wepi.cache.springrestredis.models;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class User implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6771824013242217298L;
	private String id;
	private String name;
	private String city;
	
}
