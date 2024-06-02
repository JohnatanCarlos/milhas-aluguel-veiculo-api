package com.milhas.core.user.infra.db.entity;

import jakarta.persistence.*;
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
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_user", nullable = false, unique = true)
    private UUID idUser;

    @OneToOne(fetch = FetchType.LAZY)  //QUANDO A RECUPERAÇÃO É CONFIGURADA COMO LAZY OS DADOS DA ENTITY RELACIONADA NAO SÃO CARREGADOS AUTOMATICAMENTE QUANDO A ENTITY PRINCIPAL É CARREGADA
    @JoinColumns({@JoinColumn(name = "id_credential", referencedColumnName = "id_credential", nullable = false, insertable = false, updatable = false)})
    private UserCredential idCredential;

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
