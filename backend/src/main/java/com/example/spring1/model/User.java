package com.example.spring1.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;
import org.springframework.stereotype.Repository;

//mongo doc with collection name

@Document(collection="users")
@Accessors(fluent = true, chain = true)
//lombok getters setters naming convention with exact variable names and can chain variables together while setting
//new User().id("1").name("random");
@Data
// generates getters, setters, equals(), hashCode(), and toString() methods for the class.
public class User {
    @Id
    //object id as ID
    private String id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("age")
    private int age;

    @JsonProperty("email")
    @Indexed(unique = true)
    private String email;

    @JsonProperty("mobile")
    @Indexed(unique = true)
    private long mobile;

    @JsonProperty("password")
    private String password;



}
