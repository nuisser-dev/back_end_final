package com.security.users.entities;



import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
@Document
public class Functionality {
	
	
	
	@Id
	 
	private String id;
	
	private String name;
	private String description;

	
	
	
	
	
}
