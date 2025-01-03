package com.milhas.core.agency.domain.service;

import com.milhas.core.agency.app.dto.response.AgencyResponseDTO;

import java.util.List;
import java.util.UUID;

public interface AgencyService {
    public List<AgencyResponseDTO> getAll(String name);

    public AgencyResponseDTO getById(UUID idAgency);

    public AgencyResponseDTO save(AgencyResponseDTO agency);

    public AgencyResponseDTO update(UUID idAgency, AgencyResponseDTO agency);

    void delete(UUID idAgency);

}
