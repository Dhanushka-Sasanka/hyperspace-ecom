package com.hyperspace.hyperspaceadvertisementapp.service.impl;


import com.hyperspace.hyperspaceadvertisementapp.dto.UserDTO;
import com.hyperspace.hyperspaceadvertisementapp.entity.User;
import com.hyperspace.hyperspaceadvertisementapp.repository.UserRepository;
import com.hyperspace.hyperspaceadvertisementapp.service.UserService;
import com.hyperspace.hyperspaceadvertisementapp.util.service.AbstractService;
import com.hyperspace.hyperspaceadvertisementapp.util.service.ResponseWrapper;
import com.hyperspace.hyperspaceadvertisementapp.util.service.SystemMessages;
import com.hyperspace.hyperspaceadvertisementapp.util.service.SystemOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;


/**
 * @author Dhanushka Paranavithana
 * @since 11/8/2021  2:42 PM
 **/
@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl extends AbstractService<UserDTO> implements UserService {


    private final UserRepository userRepository;
    private final ModelMapper modelMapper;


    @Override
    public ResponseEntity<ResponseWrapper<Page<UserDTO>>> getAllUsers(Pageable pageable) {
        ResponseEntity<ResponseWrapper<Page<UserDTO>>> response;

        Page<UserDTO> userDTOPage = null;

        Page<User> usersPages = userRepository.findAll(pageable);

        if (!usersPages.isEmpty()) {
            userDTOPage = usersPages.map(userEntity -> modelMapper.map(userEntity, UserDTO.class));
            response = ResponseEntity.status(HttpStatus.FOUND)
                    .headers(new HttpHeaders())
                    .body(new ResponseWrapper<>(SystemOperation.READ.withSuccess(), SystemMessages.SUCCESSFULLY_LOADED, userDTOPage));
        } else {
            response = buildNotFoundResponseWrappedForPage();
        }
        return response;
    }


    @Override
    public ResponseEntity<ResponseWrapper<UserDTO>> createUser(UserDTO userDTO) {
        ResponseEntity<ResponseWrapper<UserDTO>> response = null;

        try {
            User user = modelMapper.map(userDTO, User.class);
            User savedUser = userRepository.save(user);
            UserDTO savedUserDTO = modelMapper.map(savedUser, UserDTO.class);
            response = buildResponseWrapped(SystemOperation.CREATE.withSuccess(), SystemMessages.USER_CREATE_SUCCESS, savedUserDTO);
        } catch (Exception e) {
            response = buildExceptionErrorResponse(SystemOperation.CREATE.withError(), SystemMessages.USER_CREATE_FAILED, e);
        }

        return response;
    }

    @Override
    public ResponseEntity<ResponseWrapper<UserDTO>> updateUser(Long cid, UserDTO userDTO) {
        return null;
    }

    @Override
    public Map<String, Boolean> deleteUser(Long userId) {
        return null;
    }

    @Override
    public ResponseEntity<ResponseWrapper<UserDTO>> searchUser(Long userId) {
        ResponseEntity< ResponseWrapper< UserDTO > > response = null;

        Optional< User > userRepositoryById = userRepository.findById( userId );

        if( userRepositoryById.isPresent() )
        {
            UserDTO existingUser = modelMapper.map(userRepositoryById.get(), UserDTO.class);
            response = buildResponseWrapped( SystemOperation.READ.withSuccess(),
                    SystemMessages.SUCCESSFULLY_LOADED, existingUser
            );
        }
        else
        {
            response = buildNotFoundResponseWrapped();
        }

        return response;
    }
}
