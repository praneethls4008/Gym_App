package com.example.spring1.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

//mongo doc with collection name

@Document(collection="users")
// generates getters, setters, equals(), hashCode(), and toString() methods for the class.
public class User implements UserDetails{

    @Id
    //object id as ID
    private String id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("age")
    private int age;

    @JsonProperty("username")
    @Indexed(unique = true)
    private String username;

    @JsonProperty("email")
    @Indexed(unique = true)
    private String email;

    @JsonProperty("mobile")
    @Indexed(unique = true)
    private long mobile;



    @JsonProperty("password")
    private String password;

    @JsonProperty("role")
    private Role role;

    public User(String name, String id, int age, String username, String email, long mobile, String password, Role role) {
        this.name = name;
        this.id = id;
        this.age = age;
        this.username = username;
        this.email = email;
        this.mobile = mobile;
        this.password = password;
        this.role = role;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setMobile(long mobile) {
        this.mobile = mobile;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", mobile=" + mobile +
                ", password='" + password + '\'' +
                ", role=" + role +
                '}';
    }



    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public long getMobile() {
        return mobile;
    }

    public Role getRole() {
        return role;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
