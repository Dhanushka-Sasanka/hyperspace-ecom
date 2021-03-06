package com.hyperspace.hyperspaceadvertisementapp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;
import javax.validation.constraints.Size;

/**
 * @author Dhanushka Paranavithana
 * @since 8/5/2021  7:52 PM
 **/

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userID;

    @Size( max = 100 )
    @Column( name = "username" )
    private String userName;

    @Column( name = "password" )
    private String password;

    @Column( name = "email" )
    private String email;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(	name = "user_roles",
            joinColumns = @JoinColumn(name = "userID"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    public User(String username, @Size(max = 100) String email) {
        this.userName = username;
        this.email = email;
    }

    public User( String username, @Size(max = 100) String email, String password) {
        this.userName = username;
        this.email = email;
        this.password = password;
    }
}
