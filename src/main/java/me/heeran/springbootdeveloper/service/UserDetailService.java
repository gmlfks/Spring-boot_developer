package me.heeran.springbootdeveloper.service;

import lombok.RequiredArgsConstructor;
import me.heeran.springbootdeveloper.repository.UserRepository;
import me.heeran.springbootdeveloper.domain.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.net.UnknownServiceException;

@RequiredArgsConstructor
@Service

public class UserDetailService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public User loadUserByUsername(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(()-> new IllegalArgumentException(email));
    }
}