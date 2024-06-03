package com.milhas.core.user.app.dto.request;

import lombok.Data;
import java.time.LocalDate;

@Data
public class UserRequestDTO {

    private String name;

    private String documentNumber;

    private String documentType;

    private String nationality;

    private String passport;

    private String phone;

    private String email;

    private LocalDate dateBirthday;

    private String password;
}
