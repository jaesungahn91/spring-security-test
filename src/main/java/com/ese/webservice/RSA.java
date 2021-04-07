package com.ese.webservice;

import lombok.Data;

import java.security.PrivateKey;

@Data
public class RSA {
    private PrivateKey privateKey;
    private String modulus;
    private String exponent;

    public RSA() {
    }

    public RSA(PrivateKey privateKey, String modulus, String exponent) {
        this.privateKey = privateKey;
        this.modulus = modulus;
        this.exponent = exponent;
    }

}
