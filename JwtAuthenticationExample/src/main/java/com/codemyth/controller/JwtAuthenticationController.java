/* package com.codemyth.controller;

import com.codemyth.jwt.JwtHelper;
import com.codemyth.model.JwtRequest;
import com.codemyth.model.JwtResponse;
import com.codemyth.model.entities.User;
import com.codemyth.reposit.UserRepository;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class JwtAuthenticationController {

    private UserDetailsService userDetailsService;
    private AuthenticationManager manager;
    private JwtHelper helper;
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    @PostMapping("/authenticate")
    public ResponseEntity<JwtResponse> login(@RequestBody JwtRequest request) {
        // authenticate
        this.doAuthenticate(request.getUsername(), request.getPassword());

        UserDetails userDetails = userDetailsService.loadUserByUsername(request.getUsername());
        String token = this.helper.generateToken(userDetails);

        JwtResponse response = JwtResponse.builder()
                .jwtToken(token)
                .username(userDetails.getUsername()).build();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody JwtRequest request) {
        // Check if user already exists
        if (userRepository.findByUsername(request.getUsername()) != null) {
            return new ResponseEntity<>("Username already taken", HttpStatus.BAD_REQUEST);
        }

        // Create a new user
        User user = User.builder()
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .roles("ROLE_USER") // Default role
                .build();

        // Save the user to the database
        userRepository.save(user);

        return new ResponseEntity<>("User registered successfully", HttpStatus.OK);
    }

    private void doAuthenticate(String username, String password) {
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(username, password);
        try {
            manager.authenticate(authentication);
        } catch (BadCredentialsException e) {
            throw new BadCredentialsException("Credentials Invalid !!");
        }
    }
}

*/














 package com.codemyth.controller;

 import com.codemyth.jwt.JwtHelper;
 import com.codemyth.model.JwtRequest;
 import com.codemyth.model.JwtResponse;
 import com.codemyth.model.entities.User;
 import com.codemyth.reposit.UserRepository;
 import lombok.AllArgsConstructor;
 import org.springframework.http.HttpStatus;
 import org.springframework.http.ResponseEntity;
 import org.springframework.security.authentication.AuthenticationManager;
 import org.springframework.security.authentication.BadCredentialsException;
 import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
 import org.springframework.security.core.userdetails.UserDetails;
 import org.springframework.security.core.userdetails.UserDetailsService;
 import org.springframework.security.crypto.password.PasswordEncoder;
 import org.springframework.web.bind.annotation.PostMapping;
 import org.springframework.web.bind.annotation.RequestBody;
 import org.springframework.web.bind.annotation.RestController;

 @RestController
 @AllArgsConstructor
 public class JwtAuthenticationController {

//     private UserDetailsService userDetailsService;

     private AuthenticationManager manager;

//     private JwtHelper helper;

     private UserDetailsService userDetailsService;
//     private AuthenticationManager manager;
     private JwtHelper helper;
     private UserRepository userRepository;
     private PasswordEncoder passwordEncoder;


     // Sign up
     @PostMapping("/signup")
     public ResponseEntity<String> signup(@RequestBody JwtRequest request) {
         // Check if user already exists
         if (userRepository.findByUsername(request.getUsername()) != null) {
             return new ResponseEntity<>("Username already taken", HttpStatus.BAD_REQUEST);
         }

         // Create a new user
         User user = User.builder()
                 .username(request.getUsername())
                 .password(passwordEncoder.encode(request.getPassword()))
                 .roles("USER") // Default role
                 .build();

         // Save the user to the database
         userRepository.save(user);

         return new ResponseEntity<>("User registered successfully", HttpStatus.OK);
     }


     //Login
     @PostMapping("/authenticate")
     public ResponseEntity<JwtResponse> login(@RequestBody JwtRequest request){
         //authenticate
         this.doAuthenticate(request.getUsername(), request.getPassword());

         UserDetails userDetails = userDetailsService.loadUserByUsername(request.getUsername());
         String token = this.helper.generateToken(userDetails);

         JwtResponse response = JwtResponse.builder()
                 .jwtToken(token)
                 .username(userDetails.getUsername()).build();
         return new ResponseEntity<>(response, HttpStatus.OK);
     }

     private void doAuthenticate(String username, String password) {
         UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(username, password);
         try {
             manager.authenticate(authentication);
         } catch (BadCredentialsException e) {
             throw new BadCredentialsException("Credentials Invalid !!");
         }
     }
 }
