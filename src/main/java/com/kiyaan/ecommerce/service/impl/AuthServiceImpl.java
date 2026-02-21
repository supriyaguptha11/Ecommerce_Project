package com.kiyaan.ecommerce.service.impl;

import com.kiyaan.ecommerce.config.JwtProvider;
import com.kiyaan.ecommerce.domain.USER_ROLE;
import com.kiyaan.ecommerce.model.Cart;
import com.kiyaan.ecommerce.model.User;
import com.kiyaan.ecommerce.repository.CartRepository;
import com.kiyaan.ecommerce.repository.UserRepository;
import com.kiyaan.ecommerce.response.SignupRequest;
import com.kiyaan.ecommerce.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import java.util.ArrayList;


@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final CartRepository cartRepository;

    private final JwtProvider jwtProvider;

    @Override
    public String createUser(SignupRequest req) {

        User user = userRepository.findByEmail(req.getEmail());

        if(user == null){
            User createdUser = new User();
            createdUser.setEmail(req.getEmail());
            createdUser.setFirstName(req.getFirstName());
            createdUser.setLastName(req.getLastName());
            createdUser.setRole(USER_ROLE.ROLE_CUSTOMER);
            createdUser.setMobileNumber("9876543210");
            createdUser.setPassword(passwordEncoder.encode(req.getOtp()));

            user = userRepository.save(createdUser);

            Cart cart = new Cart();
            cart.setUser(user);
            cartRepository.save(cart);
;
        }

        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(USER_ROLE.ROLE_CUSTOMER.toString()));

        Authentication authentication = new UsernamePasswordAuthenticationToken(req.getEmail(),null,authorities);

        SecurityContextHolder.getContext().setAuthentication(authentication);

        return jwtProvider.generateToken(authentication);
    }
}
