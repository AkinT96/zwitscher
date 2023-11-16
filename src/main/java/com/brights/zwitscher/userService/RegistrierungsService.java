package com.brights.zwitscher.userService;

import com.brights.zwitscher.session.Session;
import com.brights.zwitscher.session.SessionRepository;
import com.brights.zwitscher.user.User;
import com.brights.zwitscher.user.UserDTO;
import com.brights.zwitscher.user.UserRegistrierenDTO;
import com.brights.zwitscher.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.server.ResponseStatusException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Service
public class RegistrierungsService {

    private final UserRepository userRepository;
    private final SessionRepository sessionRepository;

    @Autowired
    public RegistrierungsService(UserRepository userRepository, SessionRepository sessionRepository) {
        this.userRepository = userRepository;
        this.sessionRepository = sessionRepository;
    }

    public UserDTO registriereUser(@Validated UserRegistrierenDTO userZuRegistrieren,
                                   BindingResult bindingResult, HttpServletResponse response) {
        if (bindingResult.hasErrors()) {
            List<FieldError> fieldErrors = bindingResult.getFieldErrors();
            List<String> errorMessages = new ArrayList<>();

            for (FieldError fieldError : fieldErrors) {
                errorMessages.add(fieldError.getDefaultMessage());
            }

            String errorMessage = String.join("   ", errorMessages);

            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, errorMessage);
        }

        if (userRepository.findByUsername(userZuRegistrieren.getUsername()).isPresent()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Benutzer existiert schon.");
        }

        if (!userZuRegistrieren.getPassword().equals(userZuRegistrieren.getPasswordBestätigung())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Die gegebenen Passwörter sind nicht gleich.");
        }

        User user = new User(userZuRegistrieren.getUsername(), userZuRegistrieren.getPassword(), userZuRegistrieren.getEmail());

        userRepository.save(user);

        Session session = new Session(user, Instant.now().plusSeconds(7 * 24 * 60 * 60));
        sessionRepository.save(session);

        Cookie cookie = new Cookie("sessionId", session.getId());
        response.addCookie(cookie);

        return new UserDTO(user.getUsername(), user.isAdmin());
    }
}
