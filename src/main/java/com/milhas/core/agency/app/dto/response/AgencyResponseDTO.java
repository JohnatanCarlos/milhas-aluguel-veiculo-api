package com.milhas.core.agency.app.dto.response;

import com.milhas.core.agency.infra.db.entity.Address;
import com.milhas.core.agency.infra.db.entity.Agency;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class AgencyResponseDTO {
    private UUID id;
    private String name;
    private String phone;
    private AddressResponseDTO address;

    public AgencyResponseDTO(Agency agency, AddressResponseDTO address){
        this.id = agency.getId();
        this.name = agency.getName();
        this.phone = agency.getPhone();
        this.address = address;
    }
}
