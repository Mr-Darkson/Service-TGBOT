package me.absolute.tgbot.auth;

import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Getter
@Component
public class TokenManager {
    private AuthToken token;

    public TokenManager() {
        //TODO GET TOKEN FROM REDIS
    }

    public AuthToken regenerateToken() {
        AuthToken newToken = new AuthToken(UUID.randomUUID().toString());
        //TODO SAVE TOKEN TO REDIS
        return newToken;
    }

}
