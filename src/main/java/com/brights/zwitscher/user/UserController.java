package com.brights.zwitscher.user;

import com.brights.zwitscher.artikel.Artikel;
import com.brights.zwitscher.artikel.ArtikelListeDTO;
import jakarta.servlet.http.HttpServletResponse;
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
    public UserListeDTO  benutzerAusgeben(@ModelAttribute("sessionUser") Optional<User> sessionUserOptional,
                                          HttpServletResponse response) {
        User sessionUser = sessionUserOptional
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Logindaten sind nicht gültig."));
        List<User> userListe = userRepository.findAll();
        for (int i = 0; i < userListe.size() ; i++) {
            if (userListe.get(i).getUsername().equals(sessionUser.getUsername())){
                userListe.remove(i);
            }
        }
        return new UserListeDTO(userListe);
    }
}