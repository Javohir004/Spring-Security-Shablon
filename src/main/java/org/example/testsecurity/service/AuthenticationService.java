package org.example.testsecurity.service;


import lombok.RequiredArgsConstructor;
import org.example.testsecurity.dto.AuthenticationResponse;
import org.example.testsecurity.dto.LoginRequest;
import org.example.testsecurity.dto.RegisterRequest;
import org.example.testsecurity.entity.User;
import org.example.testsecurity.enums.Role;
import org.example.testsecurity.exception.InvalidCredentialsException;
import org.example.testsecurity.exception.UserAlreadyExistsException;
import org.example.testsecurity.exception.UserNotFoundException;
import org.example.testsecurity.repo.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    /**
     * Ro'yxatdan o'tish
     */
    public AuthenticationResponse register(RegisterRequest request) {
        // Email mavjudligini tekshirish
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new UserAlreadyExistsException(
                    "Bu email allaqachon ro'yxatdan o'tgan: " + request.getEmail()
            );
        }

        // Yangi user yaratish
        var user = User.builder()
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .role(Role.USER)
                .enabled(true)
                .build();

        userRepository.save(user);

        // Token yaratish
        var jwtToken = jwtService.generateToken(user);
        var refreshToken = jwtService.generateRefreshToken(user);

        return AuthenticationResponse.builder()
                .accessToken(jwtToken)
                .refreshToken(refreshToken)
                .build();
    }

    /**
     * Tizimga kirish
     */
    public AuthenticationResponse login(LoginRequest request) {
        try {
            // Authentication
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.getEmail(),
                            request.getPassword()
                    )
            );
        } catch (BadCredentialsException ex) {
            throw new InvalidCredentialsException("Email yoki parol noto'g'ri");
        }

        // User topish
        var user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new UserNotFoundException(
                        "Foydalanuvchi topilmadi: " + request.getEmail()
                ));

        // Token yaratish
        var jwtToken = jwtService.generateToken(user);
        var refreshToken = jwtService.generateRefreshToken(user);

        return AuthenticationResponse.builder()
                .accessToken(jwtToken)
                .refreshToken(refreshToken)
                .build();
    }
}
