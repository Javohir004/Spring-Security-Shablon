package org.example.testsecurity.controller;



import org.example.testsecurity.dto.AuthenticationResponse;
import org.example.testsecurity.dto.LoginRequest;
import org.example.testsecurity.dto.RegisterRequest;
import org.example.testsecurity.service.AuthenticationService;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@Tag(name = "Authentication", description = "Authentication va Registration endpoint'lari")
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    @Operation(summary = "Ro'yxatdan o'tish", description = "Yangi foydalanuvchi ro'yxatdan o'tadi va JWT token oladi")
    public ResponseEntity<AuthenticationResponse> register(@Valid @RequestBody RegisterRequest request) {
        return ResponseEntity.ok(authenticationService.register(request));
    }

    @PostMapping("/login")
    @Operation(summary = "Tizimga kirish", description = "Mavjud foydalanuvchi tizimga kiradi va JWT token oladi")
    public ResponseEntity<AuthenticationResponse> login(@Valid @RequestBody LoginRequest request) {
        return ResponseEntity.ok(authenticationService.login(request));
    }
}
