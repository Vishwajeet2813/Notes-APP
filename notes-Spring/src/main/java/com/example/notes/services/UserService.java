package com.example.notes.services;

import com.example.notes.dto.UserDTO;
import com.example.notes.models.Role;
import com.example.notes.models.User;
import com.warrenstrange.googleauth.GoogleAuthenticatorKey;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;
import java.util.Optional;

public interface UserService {
    void updateUserRole(Long userId, String roleName);

    List<User> getAllUsers();

    UserDTO getUserById(Long id);

    User findByUserName(String username);

    void updateAccountLockStatus(Long userId, Boolean lock);

    List<Role> getAllRoles();

    void updateAccountExpiryStatus(Long userId, Boolean expire);

    void updateAccountEnabledStatus(Long userId, Boolean enabled);

    void updatePassword(Long userId, String password);

    void updateCredientialsExpiryStatus(Long userId, Boolean expire);

    void generatePasswordResetToken(String email);

    void resetPassword(String token, String newPassword);

    Optional<User> findByEmail(String email);

    User regiseterUser(User newUser);

    GoogleAuthenticatorKey generate2FASecret(Long userId);

    boolean validate2FACode(Long userId, int code);

    void enable2FA(Long userId);

    void disable2FA(Long userId);
}

