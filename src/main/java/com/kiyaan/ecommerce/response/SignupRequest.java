package com.kiyaan.ecommerce.response;

import lombok.Data;

@Data
public class SignupRequest {
    private String email;

    private String firstName;

    private String lastName;

    private String otp;
}
