package com.example.spring1.model;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

//mongo doc with collection name
@Document(collection="users")
@Accessors(fluent = true, chain = true)
//lombok getters setters naming convention with exact variable names and can chain variables together while setting
//new User().id("1").name("random");
@Data
// generates getters, setters, equals(), hashCode(), and toString() methods for the class.
public class User {
    @MongoId(FieldType.OBJECT_ID)
    //object id as ID
    private String id;

    private String name;

    private int age;

    @Indexed(unique = true)
    private String email;

    @Indexed(unique = true)
    private long mobile;

    private String password;



}
