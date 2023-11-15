package com.brights.zwitscher.user;

import com.brights.zwitscher.session.Session;
import com.brights.zwitscher.session.SessionRepository;
import jakarta.servlet.http.Cookie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.time.Instant;

@RestController
public class RegistrierungsController {
    private UserRepository userRepository;
    private SessionRepository sessionRepository;


    @Autowired
    public RegistrierungsController(UserRepository userRepository, SessionRepository sessionRepository){
        this.userRepository = userRepository;
        this.sessionRepository = sessionRepository;
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

        Session session = new Session(user,Instant.now().plusSeconds(7*24*60*60));
        sessionRepository.save(session);

        Cookie cookie = new Cookie("sessionId",session.getId() );

        return new UserDTO(user.getUsername(), user.isAdmin());
    }
}
