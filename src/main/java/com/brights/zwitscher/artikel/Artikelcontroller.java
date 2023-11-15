package com.brights.zwitscher.artikel;

import com.brights.zwitscher.user.User;
import com.brights.zwitscher.user.UserDTO;
import com.brights.zwitscher.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RestController
public class Artikelcontroller {




        private UserRepository userRepository;

        @Autowired
        public Artikelcontroller(UserRepository userRepository) {
            this.userRepository = userRepository;
        }

        @GetMapping("/posts")
        public UserDTO user(@ModelAttribute("sessionUser") Optional<User> sessionUserOptional) {
            User sessionUser = sessionUserOptional
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.UNAUTHORIZED, "No valid login"));
            return new UserDTO(sessionUser.getUsername(), sessionUser.isAdmin());
        }
}
