package com.milhas.core.agency.app.dto.response;

import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class AgencyResponseDTO {
    private UUID idUser;
    private String name;
    private String phone;
    private List<AddressResponseDTO> address;
}
