package com.hyperspace.hyperspaceadvertisementapp.controller;

import com.hyperspace.hyperspaceadvertisementapp.dto.auth.JwtResponse;
import com.hyperspace.hyperspaceadvertisementapp.dto.auth.LoginRequest;
import com.hyperspace.hyperspaceadvertisementapp.dto.auth.MessageResponse;
import com.hyperspace.hyperspaceadvertisementapp.dto.auth.SignUpRequest;
import com.hyperspace.hyperspaceadvertisementapp.entity.Role;
import com.hyperspace.hyperspaceadvertisementapp.entity.User;
import com.hyperspace.hyperspaceadvertisementapp.entity.type.RoleType;
import com.hyperspace.hyperspaceadvertisementapp.repository.RoleRepository;
import com.hyperspace.hyperspaceadvertisementapp.repository.UserRepository;
import com.hyperspace.hyperspaceadvertisementapp.util.security.jwt.JwtUtils;
import com.hyperspace.hyperspaceadvertisementapp.util.security.services.custome.impl.UserDetailsImpl;
import com.hyperspace.hyperspaceadvertisementapp.util.service.UrlProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author dhanushka Paranavithana
 * @since 11/08/2021 02:34 PM
 */

@RestController
@RequestMapping(UrlProvider.AUTH_SERVICE)
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationManager authenticationManager;

    private final UserRepository userRepository;

    private final RoleRepository roleRepository;

    private final PasswordEncoder encoder;

    private final JwtUtils jwtUtils;

    /**
     * Authenticating User
     *
     * @param loginRequest The LoginRequest instance
     * @return jwtResponse instance
     */

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

        System.out.println("loginRequest = " + loginRequest);
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUserName(),
                        loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());

        return ResponseEntity.ok(new JwtResponse(jwt,
                userDetails.getUser_id(),
                userDetails.getUsername(),
                userDetails.getEmail(),
                roles));
    }
    /**
     * Creating new User
     * @param signUpRequest The signUpRequest instance
     * @return MessageResponse instance
     */
    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpRequest signUpRequest) {
        if (userRepository.existsByUserName(signUpRequest.getUsername())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Username is already taken!"));
        }

        if (userRepository.existsByEmail(signUpRequest.getEmail())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Email is already in use!"));
        }

        // Create new user's account
        System.out.println("signUpRequest = " + signUpRequest);
        User user = new User(
                0,
                signUpRequest.getUsername(),
                encoder.encode(signUpRequest.getPassword()),
                signUpRequest.getEmail(),
                null);

        Set<String> strRoles = signUpRequest.getRole();
        Set<Role> roles = new HashSet<>();

        if (strRoles == null) {
            Role userRole = roleRepository.findByRole(RoleType.ROLE_USER)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(userRole);
        } else {
            strRoles.forEach(role -> {
                switch (role) {
                    case "admin":
                        Role adminRole = roleRepository.findByRole(RoleType.ROLE_ADMIN)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(adminRole);
                        break;

                    default:
                        Role userRole = roleRepository.findByRole(RoleType.ROLE_USER)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(userRole);
                }
            });
        }

        user.setRoles(roles);
        userRepository.save(user);

        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
    }

}
