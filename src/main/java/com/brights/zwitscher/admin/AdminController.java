package com.brights.zwitscher.admin;

import com.brights.zwitscher.artikel.ArtikelRepository;
import com.brights.zwitscher.kommentare.KommentarRepository;
import com.brights.zwitscher.user.User;
import com.brights.zwitscher.user.UserDTO;
import com.brights.zwitscher.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RestController
public class AdminController {
    private ArtikelRepository artikelRepository;
    private UserRepository userRepository;
    private KommentarRepository kommentarRepository;

    @Autowired
    public AdminController(ArtikelRepository artikelRepository, UserRepository userRepository,
                           KommentarRepository kommentarRepository){
        this.artikelRepository = artikelRepository;
        this.userRepository = userRepository;
        this.kommentarRepository = kommentarRepository;
    }

    @GetMapping("/setzealsadmin/{userId}")
    public User alsAdminSetzen(@PathVariable Long userId, @ModelAttribute("sessionUser") Optional<User> sessionUserOptional){
        User user = sessionUserOptional.orElseThrow(() -> new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Logindaten sind nicht gültig."));
        if (!user.isAdmin()) throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Du bist kein Admin");
        User userAlsAdmin = userRepository.findById(userId).orElseThrow(() -> new ResponseStatusException(HttpStatus.CONFLICT, "Der Benutzername existiert nicht."));
        userAlsAdmin.setAdmin(true);
        return userRepository.save(userAlsAdmin);
          }
}
