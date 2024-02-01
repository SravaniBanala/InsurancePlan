package com.edu.neu.INFO7255Demo3.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.edu.neu.INFO7255Demo3.model.JwtKeys;

import java.security.*;

@Configuration
public class JwtConfiguration {

    @Bean
    public JwtKeys getKeys() throws NoSuchAlgorithmException {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(2048);
        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        PublicKey publicKey = keyPair.getPublic();
        PrivateKey privateKey = keyPair.getPrivate();
        return new JwtKeys(publicKey, privateKey);
    }
}
