package com.brights.zwitscher.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class RegistrierungsController {
    private UserRepository userRepository;

    @Autowired
    public RegistrierungsController(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @PostMapping("/registriere")
    public UserDTO registriereUser(@RequestBody UserRegistrierenDTO userZuRegistrieren){
        if (userRepository.findByUsername(userZuRegistrieren.getUsername()).isPresent()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "User already exists");
        }
        if ( !userZuRegistrieren.getPassword().equals(userZuRegistrieren.getPasswordBestätigung())){
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Your provided passwords are not equal");
        }
        // mehrere User können die gleiche email Adresse haben
        User user = new User(userZuRegistrieren.getUsername(), userZuRegistrieren.getPassword());
        userRepository.save(user);
        return new UserDTO(user.getUsername(), user.isAdmin());
    }
}
