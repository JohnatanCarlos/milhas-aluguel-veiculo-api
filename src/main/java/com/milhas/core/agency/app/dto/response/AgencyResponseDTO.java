package com.milhas.core.agency.app.dto.response;

import com.milhas.core.agency.infra.db.entity.Agency;
import com.milhas.core.vehicle.app.dto.response.GroupVehicleResponseDTO;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class AgencyResponseDTO {
    private UUID id;
    private String name;
    private String code;
    private String phone;
    private AddressResponseDTO address;
    private List<GroupVehicleResponseDTO> groups;

    public AgencyResponseDTO(Agency agency, AddressResponseDTO address, List<GroupVehicleResponseDTO> groups){
        this.id = agency.getId();
        this.code = agency.getCode();
        this.name = agency.getName();
        this.phone = agency.getPhone();
        this.address = address;
        this.groups = groups;
    }
}
