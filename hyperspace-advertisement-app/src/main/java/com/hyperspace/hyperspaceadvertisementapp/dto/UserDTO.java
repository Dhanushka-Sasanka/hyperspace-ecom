package com.hyperspace.hyperspaceadvertisementapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.usertype.UserType;

/**
 * @author Dhanushka Paranavithana
 * @since 8/5/2021  7:52 PM
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private Long userID;
    private String userName;
    private String userEmail;
    private UserType userType;
    private String password;

}
