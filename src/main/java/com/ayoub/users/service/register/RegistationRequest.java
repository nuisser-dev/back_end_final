package com.ayoub.users.service.register;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data @AllArgsConstructor @NoArgsConstructor
public class RegistationRequest {

	private String username;
	private String password;
	private String email;

}
