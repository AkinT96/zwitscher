package com.brights.zwitscher.user;
import com.brights.zwitscher.userService.RegistrierungsService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrierungsController {

    private final RegistrierungsService registrierungsService;

    @Autowired
    public RegistrierungsController(RegistrierungsService registrierungsService) {
        this.registrierungsService = registrierungsService;
    }

    @PostMapping("/registriere")
    public UserDTO registriereUser(@Validated @RequestBody UserRegistrierenDTO userZuRegistrieren,
                                   BindingResult bindingResult, HttpServletResponse response) {
        return registrierungsService.registriereUser(userZuRegistrieren, bindingResult, response);
    }
}
