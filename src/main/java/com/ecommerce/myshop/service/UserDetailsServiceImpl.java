package com.ecommerce.myshop.service;

import com.ecommerce.myshop.domain.User;
import com.ecommerce.myshop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> optUser = userRepository.findByUsername(username);
        if (optUser.isPresent()) {
            User user = optUser.get();
            List<String> lstRoles = new ArrayList<>();
            user.getRoles().stream().forEach(role -> lstRoles.add(role.getName()));

            return org.springframework.security.core.userdetails.User.builder()
                    .username(user.getUsername())
                    .password(bCryptPasswordEncoder.encode(user.getPassword()))
                    .disabled(false)
                    .accountExpired(false)
                    .credentialsExpired(false)
                    .roles(lstRoles.toArray(new String[0]))
                    .build();
        } else {
            throw new UsernameNotFoundException("Kullanici bulunamadi!");
        }
    }


}
