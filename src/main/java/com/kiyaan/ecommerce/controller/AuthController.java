package com.kiyaan.ecommerce.controller;

import com.kiyaan.ecommerce.domain.USER_ROLE;
import com.kiyaan.ecommerce.repository.UserRepository;
import com.kiyaan.ecommerce.response.AuthResponse;
import com.kiyaan.ecommerce.response.SignupRequest;
import com.kiyaan.ecommerce.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.kiyaan.ecommerce.model.User;


@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final UserRepository userRepository;
    private final AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<AuthResponse> createUserHandler(@RequestBody SignupRequest req){

        String jwt = authService.createUser(req);

        AuthResponse res = new AuthResponse();
        res.setJwt(jwt);
        res.setMessage("register success");
        res.setRole(USER_ROLE.ROLE_CUSTOMER);

        return ResponseEntity.ok(res);









//        User user = new User();
//        user.setEmail(req.getEmail());
//        user.setFirstName(req.getFirstName());
//        user.setLastName(req.getLastName());
//
//        User savedUser = userRepository.save(user);
   //     return ResponseEntity.ok(savedUser);

    }


}
