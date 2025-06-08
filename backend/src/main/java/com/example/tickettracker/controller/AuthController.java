package backend.src.main.java.com.example.tickettracker.controller;

import backend.src.main.java.com.example.tickettracker.dto.LoginRequest;
import backend.src.main.java.com.example.tickettracker.dto.SignUpRequest;
import backend.src.main.java.com.example.tickettracker.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;


    @PostMapping("/signup")
    public ResponseEntity<?> register(@RequestBody SignUpRequest request) {
        return authService.registerUser(request);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        return authService.authenticateUser(request);
    }
}

