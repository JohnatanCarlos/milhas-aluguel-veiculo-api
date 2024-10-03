package com.milhas.core.agency.mapper;

import com.milhas.core.agency.app.dto.request.AgencyRequestDTO;
import com.milhas.core.agency.app.dto.response.AddressResponseDTO;
import com.milhas.core.agency.app.dto.response.AgencyResponseDTO;
import com.milhas.core.agency.infra.db.entity.Address;
import com.milhas.core.agency.infra.db.entity.Agency;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AgencyMapper {
    public Agency toEntity(AgencyRequestDTO request) {
        return Agency.builder()
                .name(request.getName())
                .phone(request.getPhone())
                .build();
    }

    public AgencyResponseDTO toResponse(Agency agency){
        AddressResponseDTO addressDTO = agency.getAddress() != null
                ?  toAddressResponse(agency.getAddress())
                : null;

        return new AgencyResponseDTO(agency, addressDTO);
    }

    // Método para converter Address em AddressResponseDTO
    private AddressResponseDTO toAddressResponse(Address address) {
        return new AddressResponseDTO(address);
    }

    public List<AgencyResponseDTO> toResponseList(List<Agency> agencyList){
        return  agencyList.stream()
                .map(agency -> {
                    AddressResponseDTO addressDTO = toAddressResponse(agency.getAddress());
                    return new AgencyResponseDTO(agency, addressDTO);
                })
                .collect(Collectors.toList());
    }
}
