package com.milhas.core.agency.app.dto.response;

import lombok.Data;

import java.util.UUID;

@Data
public class AddressResponseDTO {
    private UUID idAddress;
    private String zipCode;
    private String street;
    private String number;
    private String district;
    private String city;
    private String country;
    private String complement;
}
