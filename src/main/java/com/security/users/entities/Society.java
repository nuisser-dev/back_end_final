package com.security.users.entities;


import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;


import com.security.users.entities.User;


import java.util.List;

import org.springframework.data.annotation.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
@Document(collection = "society")
public class Society {

	
	@Id
	
	private String id;
	
	private String name;
	
	

	private String code;
	  
@DBRef
	  private List<User> users;
	
}
