package com.milhas.core.user.app.dto.response;

import com.milhas.core.user.infra.db.entity.User;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class UserResponseDTO {

    private UUID idUser;

    private String name;

    private String documentNumber;

    private String documentType;

    private String nationality;

    private String phone;

    private String email;

    private LocalDate dateBirthday;

    private LocalDateTime createDate;

    private LocalDateTime updateDate;

    private Boolean isActive;

    public UserResponseDTO(User user) {
        this.idUser = user.getIdUser();
        this.name = user.getName();
        this.documentNumber = user.getDocumentNumber();
        this.documentType = user.getDocumentType();
        this.nationality = user.getNationality();
        this.phone = user.getPhone();
        this.email = user.getEmail();
        this.dateBirthday = user.getDateBirthday();
        this.createDate = user.getCreateDate();
        this.updateDate = user.getUpdateDate();
        this.isActive = user.getIsActive();
    }
}
