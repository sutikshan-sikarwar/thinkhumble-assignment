package com.example.thinkhumble.security;

import com.example.thinkhumble.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {
    	return userRepository.findByUsername(username)
    		    .map(user -> User.withUsername(user.getUsername())
    		                     .password(user.getPassword())  // <- already hashed
    		                     .roles("USER")
    		                     .build())
    		    .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }
}
