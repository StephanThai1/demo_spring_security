package com.stephan.demo_spring_security.security;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class CustomUserDetailService implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<SimpleGrantedAuthority> roles = new ArrayList<>();
        if ("admin".equals(username)) {
            SimpleGrantedAuthority adminRole = new SimpleGrantedAuthority("ROLE_ADMIN");
            roles.add(adminRole);
            return new User("admin", "$2a$12$bWtZfVDI.hivceUsVq0As.IkUUJOdh2BCRE2b4YTPTSaMtIU7kDIm", roles);
        } else if ("user".equals(username)) {
            SimpleGrantedAuthority userRole = new SimpleGrantedAuthority("ROLE_USER");
            roles.add(userRole);
            return new User("user", "$2a$12$bWtZfVDI.hivceUsVq0As.IkUUJOdh2BCRE2b4YTPTSaMtIU7kDIm", roles);
        }
        throw new UsernameNotFoundException("User is not found for username: " + username);
    }
}
