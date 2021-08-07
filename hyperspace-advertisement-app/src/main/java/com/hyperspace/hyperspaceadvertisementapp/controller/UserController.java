package com.hyperspace.hyperspaceadvertisementapp.controller;

import com.hyperspace.hyperspaceadvertisementapp.dto.UserDTO;
import com.hyperspace.hyperspaceadvertisementapp.service.UserService;
import com.hyperspace.hyperspaceadvertisementapp.util.service.ResponseWrapper;
import com.hyperspace.hyperspaceadvertisementapp.util.service.UrlProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Common API response wrapper
 *
 * @author Dhanushka Paranavithana
 * @since 8/5/2021  7:52 PM
 **/
@CrossOrigin(origins = "*")
@RestController
@RequestMapping(UrlProvider.USER_SERVICE)
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    /**
     * Get All Users in Page wise
     *
     * @param pageable The Pageable
     * @return Page of papers
     */
    @GetMapping("/users")
    public ResponseEntity<ResponseWrapper<Page<UserDTO>>> getAllUsers(Pageable pageable) {
        return userService.getAllUsers(pageable);
    }

    /**
     * Get a single user
     *
     * @param userId The User ID
     * @return The UserDTO
     */
    @GetMapping("/users/{id}")
    public ResponseEntity<ResponseWrapper<UserDTO>> getUser(@PathVariable("id") long userId) {
        return userService.searchUser(userId);
    }

    /**
     * Create a User
     *
     * @param userDTO The UserDTO
     * @return Saved UserDTO
     */
    @PostMapping("/users")
    public ResponseEntity<ResponseWrapper<UserDTO>> createUser(@RequestBody UserDTO userDTO) {
        return userService.createUser(userDTO);
    }

//    /**
//     * Update a paper
//     *
//     * @param user   The User
//     * @param userId The UserID
//     * @return Updated paper
//     */
//    @PutMapping("/papers/{id}")
//    public ResponseEntity< ResponseWrapper< User > > updateUser( @RequestBody User user,@PathVariable("id") Long UserID )
//    {
//        return userService.updateUser( paper , paperId );
//    }
//
//    /**
//     * Delete a paper
//     *
//     * @param paperId The User ID
//     * @return Delete status
//     */
//    @DeleteMapping("/papers/{id}")
//    public ResponseEntity< ResponseWrapper< User > > deleteUser(@PathVariable("id") Long paperId )
//    {
//        return userService.deleteUser( paperId );
//    }


}
