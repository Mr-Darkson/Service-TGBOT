package me.absolute.tgbot.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "admin")
public class Admin {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "chat_id")
    @NotNull
    private Long chat_id;

    @Column(name = "username")
    private String username;

    @Column(name = "created_in")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime created_in;

    @Column(name = "auth_token")
    private String auth_token;

}
