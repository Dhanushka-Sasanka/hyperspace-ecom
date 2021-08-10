package com.hyperspace.hyperspaceadvertisementapp.dto.auth;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author dhanu
 * @since 3/2/2021 2:45 PM
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequest {

    private String userName;
    private String password;
}
