package com.example.notes.services;

import com.warrenstrange.googleauth.GoogleAuthenticatorKey;

public interface TotoService {
    GoogleAuthenticatorKey generateSecret();

    String getQrCodeUrl(GoogleAuthenticatorKey secret, String username);

    boolean verifyCode(String secret, int code);
}
