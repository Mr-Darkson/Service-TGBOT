package me.absolute.tgbot.auth;

import lombok.AllArgsConstructor;
import lombok.Setter;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@Setter
@AllArgsConstructor
@RedisHash("authToken")
public class AuthToken implements Serializable {
    private String value;

    public String getValue() {
        return value;
    }
}
