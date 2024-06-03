package com.milhas.core.user.infra.db.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "user_credential")
public class UserCredential {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_credential" , nullable = false, unique = true)
    private UUID idCredential;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "acess_token")
    private String acessToken;

    @Column(name = "refresh_token")
    private String refreshToken;

    @Column(name = "role")
    private String role;

}
