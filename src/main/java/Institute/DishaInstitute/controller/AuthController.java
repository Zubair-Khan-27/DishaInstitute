package Institute.DishaInstitute.controller;

import Institute.DishaInstitute.dto.LoginRequest;
import Institute.DishaInstitute.dto.LoginResponse;
import Institute.DishaInstitute.dto.RegisterRequest;
import Institute.DishaInstitute.security.JwtUtil;
import Institute.DishaInstitute.service.AuthService;

import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;
    private final AuthService authService;

    public AuthController(
            AuthenticationManager authenticationManager,
            JwtUtil jwtUtil,
            AuthService authService) {

        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
        this.authService = authService;
    }

    // ================= REGISTER =================

    @PostMapping("/register")
    public ResponseEntity<?> register(
            @Valid @RequestBody RegisterRequest request) {

        return authService.register(request);
    }

    // ================= LOGIN =================

    @PostMapping("/login")
    public ResponseEntity<?> login(
            @Valid @RequestBody LoginRequest request) {

        Authentication authentication =
                authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(
                                request.getEmail(),
                                request.getPassword()
                        )
                );

        String role = authentication.getAuthorities()
                .iterator()
                .next()
                .getAuthority()
                .replace("ROLE_", "");

        String token = jwtUtil.generateToken(
                request.getEmail(),
                role
        );

        return ResponseEntity.ok(
                new LoginResponse(
                        token,
                        request.getEmail(),
                        role
                )
        );
    }
}