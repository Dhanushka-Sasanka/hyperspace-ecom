package com.hyperspace.hyperspaceadvertisementapp.service;

import com.hyperspace.hyperspaceadvertisementapp.dto.UserDTO;
import com.hyperspace.hyperspaceadvertisementapp.repository.UserRepository;
import com.hyperspace.hyperspaceadvertisementapp.util.service.AbstractService;
import com.hyperspace.hyperspaceadvertisementapp.util.service.ResponseWrapper;
import org.apache.catalina.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author Dhanushka Paranavithana
 * @since 8/5/2021  8:03 PM
 **/

public interface UserService {

//    final UserRepository userRepository;

    ResponseEntity<ResponseWrapper<Page< UserDTO>>> getAllUsers(Pageable pageable  );

    ResponseEntity<ResponseWrapper<UserDTO>> createUser(UserDTO userDTO);

    ResponseEntity<ResponseWrapper<UserDTO>> updateUser(Long cid, UserDTO userDTO);

    Map<String , Boolean> deleteUser(Long userId);

    ResponseEntity<ResponseWrapper<UserDTO>> searchUser(Long userId);



}
