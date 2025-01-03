package com.milhas.core.user.infra.db.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Collections;
import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_user", nullable = false, unique = true)
    private UUID idUser;

    @OneToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST})  //QUANDO A RECUPERAÇÃO É CONFIGURADA COMO LAZY OS DADOS DA ENTITY RELACIONADA NAO SÃO CARREGADOS AUTOMATICAMENTE QUANDO A ENTITY PRINCIPAL É CARREGADA
    @JoinColumn(name = "id_credential", nullable = false)
    private UserCredential userCredential;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "document_number", nullable = false, unique = true)
    private String documentNumber;

    @Column(name = "document_type", nullable = false)
    private String documentType;

    @Column(name = "nationality", nullable = false)
    private String nationality;

    @Column(name = "phone", nullable = false)
    private String phone;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "date_birthday", nullable = false)
    private LocalDate dateBirthday;

    @Column(name = "create_date", nullable = false)
    private LocalDateTime createDate = LocalDateTime.now();

    @Column(name = "update_date")
    private LocalDateTime updateDate;

    @Column(name = "is_active", nullable = false)
    private Boolean isActive = true;

    @Builder
    public User(String name, String documentNumber, String documentType, String nationality, String phone, String email, LocalDate dateBirthday) {
        this.name = name;
        this.documentNumber = documentNumber;
        this.documentType = documentType;
        this.nationality = nationality;
        this.phone = phone;
        this.email = email;
        this.dateBirthday = dateBirthday;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.emptyList();
    }

    @Override
    public String getPassword() {
        return userCredential.getPassword();
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
