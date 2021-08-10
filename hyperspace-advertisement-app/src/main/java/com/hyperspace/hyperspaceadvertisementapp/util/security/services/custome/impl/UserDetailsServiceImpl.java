package com.hyperspace.hyperspaceadvertisementapp.util.security.services.custome.impl;


import com.hyperspace.hyperspaceadvertisementapp.entity.User;
import com.hyperspace.hyperspaceadvertisementapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * @author Dhanushka Paranavithana
 * @since 8/11/2021  2:15 AM
 **/
@Service
public class UserDetailsServiceImpl  implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUserName(username)
                .orElseThrow(() ->
                        new UsernameNotFoundException("User Not Found with username: " + username));
        return UserDetailsImpl.build(user);
    }
}
