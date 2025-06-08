package backend.src.main.java.com.example.tickettracker.service;

import backend.src.main.java.com.example.tickettracker.auth.JwtTokenProvider;
import backend.src.main.java.com.example.tickettracker.dto.JwtResponse;
import backend.src.main.java.com.example.tickettracker.dto.LoginRequest;
import backend.src.main.java.com.example.tickettracker.dto.SignUpRequest;
import backend.src.main.java.com.example.tickettracker.entity.Role;
import backend.src.main.java.com.example.tickettracker.entity.User;
import backend.src.main.java.com.example.tickettracker.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;



    public ResponseEntity<?> registerUser(SignUpRequest request) {
        if (userRepository.existsByUsername(request.getUsername())) {
            return ResponseEntity
                    .badRequest()
                    .body("Username is already taken!");
        }

        User user = new User();
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(Role.USER);

        userRepository.save(user);
        return ResponseEntity.ok("User registered successfully!");
    }

    public ResponseEntity<?> authenticateUser(LoginRequest request) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(), request.getPassword())
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtTokenProvider.generateToken(authentication);

        return ResponseEntity.ok(new JwtResponse(token));
    }
}
