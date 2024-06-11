package com.milhas.core.agency.app.dto.request;

import lombok.Data;

@Data
public class AgencyRequestDTO {
    private String zipCode;
    private String street;
    private String number;
    private String district;
    private String city;
    private String country;
    private String complement;
}
