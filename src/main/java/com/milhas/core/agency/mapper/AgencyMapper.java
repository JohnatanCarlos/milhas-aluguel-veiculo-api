package com.milhas.core.agency.mapper;

import com.milhas.core.agency.app.dto.request.AgencyRequestDTO;
import com.milhas.core.agency.app.dto.response.AddressResponseDTO;
import com.milhas.core.agency.app.dto.response.AgencyResponseDTO;
import com.milhas.core.agency.infra.db.entity.Address;
import com.milhas.core.agency.infra.db.entity.Agency;
import com.milhas.core.vehicle.app.dto.response.GroupVehicleResponseDTO;
import com.milhas.core.vehicle.infra.db.entity.GroupVehicle;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AgencyMapper {
    public Agency toEntity(AgencyRequestDTO request) {
        return Agency.builder()
                .name(request.getName())
                .phone(request.getPhone())
                .code(request.getCode())
                .build();
    }

    public AgencyResponseDTO toResponse(Agency agency) {
        AddressResponseDTO addressDTO = agency.getAddress() != null
                ? toAddressResponse(agency.getAddress())
                : null;

        List<GroupVehicleResponseDTO> groupVehicleResponseDTO = agency.getGroups() != null
                ? toGroupVehicleResponse(agency.getGroups())
                : null;

        return new AgencyResponseDTO(agency, addressDTO, groupVehicleResponseDTO);
    }

    // Método para converter Address em AddressResponseDTO
    private AddressResponseDTO toAddressResponse(Address address) {
        return new AddressResponseDTO(address);
    }

    public List<AgencyResponseDTO> toResponseList(List<Agency> agencyList) {
        return  agencyList.stream()
                .map(agency -> {
                    AddressResponseDTO addressDTO = toAddressResponse(agency.getAddress());
                    List<GroupVehicleResponseDTO> groupVehicleDTO = toGroupVehicleResponse(agency.getGroups());
                    return new AgencyResponseDTO(agency, addressDTO, groupVehicleDTO);
                })
                .collect(Collectors.toList());
    }

    private List<GroupVehicleResponseDTO> toGroupVehicleResponse(List<GroupVehicle> groupVehicles) {
        return groupVehicles.stream()
                .map(GroupVehicleResponseDTO::new) // Converte cada GroupVehicle em um DTO
                .collect(Collectors.toList()); // Retorna uma lista de DTOs
    }
}
