package com.milhas.core.agency.app.dto.response;

import com.milhas.core.agency.infra.db.entity.Address;
import lombok.Data;

import java.util.UUID;

@Data
public class AddressResponseDTO {
    private UUID id;
    private String zipCode;
    private String street;
    private String number;
    private String district;
    private String city;
    private String country;
    private String complement;

    public AddressResponseDTO(Address address){
        this.id = address.getId();
        this.zipCode = address.getZipCode();
        this.street = address.getStreet();
        this.number = address.getNumber();
        this.district = address.getDistrict();
        this.city = address.getCity();
        this.country = address.getCountry();
        this.complement = address.getComplement();
    }
}
