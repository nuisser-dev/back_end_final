package com.ayoub.users.service.register;

import java.util.Calendar;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.ayoub.users.entities.User;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@Document(collection = "verification_tokens")
@NoArgsConstructor 
public class VerificationToken {
    @Id 
    private String id; // Use String as ID type for MongoDB

    private String token;

    @Field("expiration_time")
    private Date expirationTime;

    private static final int EXPIRATION_TIME = 15; 

    @Field("user_id")
    private User user; 

    public VerificationToken(String token, User user) { 
        super(); 
        this.token = token; 
        this.user = user; 
        this.expirationTime = getTokenExpirationTime(); 
    } 

    public VerificationToken(String token) { 
        super(); 
        this.token = token; 
        this.expirationTime = getTokenExpirationTime(); 
    } 

    private Date getTokenExpirationTime() { 
        Calendar calendar = Calendar.getInstance(); 
        calendar.add(Calendar.MINUTE, EXPIRATION_TIME); 
        return calendar.getTime(); 
    } 
}
