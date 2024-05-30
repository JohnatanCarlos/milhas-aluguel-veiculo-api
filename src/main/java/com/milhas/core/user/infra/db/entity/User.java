package com.milhas.core.user.infra.db.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "tb_user")
public class User {

    @Id
    @Column(name = "id_user", nullable = false, unique = true)
    private UUID idUser;

    @Column(name = "id_credential", nullable = false, unique = true)
    private UUID idCredential;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "document_number", nullable = false, unique = true)
    private String documentNumber;

    @Column(name = "document_type", nullable = false)
    private String documentType;

    @Column(name = "nationality", nullable = false)
    private String nationality;

    @Column(name = "passport", nullable = false, unique = true)
    private String passport;

    @Column(name = "phone", nullable = false)
    private String phone;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "date_birthday", nullable = false)
    private LocalDate dateBirthday;

    @Column(name = "create_date", nullable = false)
    private LocalDateTime createDate;

    @Column(name = "update_date")
    private LocalDateTime updateDate;

    @Column(name = "is_active", nullable = false)
    private Boolean isActive;

    @Builder
    public User(String name, String documentNumber, String documentType, String nationality, String passport, String phone, String email, LocalDate dateBirthday) {
        this.name = name;
        this.documentNumber = documentNumber;
        this.documentType = documentType;
        this.nationality = nationality;
        this.passport = passport;
        this.phone = phone;
        this.email = email;
        this.dateBirthday = dateBirthday;
    }
}
