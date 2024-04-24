package com.security.users.entities;



import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data @NoArgsConstructor @AllArgsConstructor
@Document(collection = "Handicap_type")
public class Handicap_type {
	@Id
	private String id;
	private String code;
	private String typehandicap;

}
