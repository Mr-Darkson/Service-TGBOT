package me.absolute.tgbot.service;

import lombok.RequiredArgsConstructor;

import me.absolute.tgbot.auth.AuthToken;
import me.absolute.tgbot.auth.TokenManager;
import me.absolute.tgbot.model.Admin;
import me.absolute.tgbot.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AdminService {
    private final AdminRepository adminRepository;
    private final TokenManager tokenManager;

    private String authToken;

    public List<Admin> getAllAdmins() {
        return adminRepository.findAll();
    }

    public Boolean authorize(String token) {
        String authToken = tokenManager.getToken().getValue();
       return authToken.equals(token);
    }

}
