package com.brights.zwitscher.user;

import com.brights.zwitscher.artikel.Artikel;
import com.brights.zwitscher.artikel.ArtikelListeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;


@RestController
public class UserController {

    private UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/user")
    public UserDTO user(@ModelAttribute("sessionUser") Optional<User> sessionUserOptional) {
        User sessionUser = sessionUserOptional
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Logindaten sind nicht gültig."));
        return new UserDTO(sessionUser.getUsername(), sessionUser.isAdmin());
    }

    @GetMapping("/benutzer")
    public UserListeDTO  benutzerAusgeben() {
        List<User> userListe = userRepository.findAllByIsAdminFalse();
        return new UserListeDTO(userListe);
    }
}