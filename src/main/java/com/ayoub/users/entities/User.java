package com.ayoub.users.entities;

import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "users") // Specifies the collection name in MongoDB
public class User {
    @Id
    private String id; // Use String as ID type for MongoDB
    @Indexed(unique = true) 
    private String username;
    
    private String password;
    private Boolean enabled;
    private String email;

    // Define the relationship between User and Role using appropriate MongoDB annotations
    // Assuming you still want to use Many-to-Many relationship
    // Adjust according to your MongoDB schema design if needed
    private List<Role> roles;
}
