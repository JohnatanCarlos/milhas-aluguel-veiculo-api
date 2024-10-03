package com.milhas.core.agency.domain.service.impl;

import com.milhas.core.agency.app.dto.response.AgencyResponseDTO;
import com.milhas.core.agency.domain.service.AgencyService;
import com.milhas.core.agency.infra.db.entity.Agency;
import com.milhas.core.agency.infra.db.repository.AgencyRepository;
import com.milhas.core.agency.mapper.AgencyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AgencyServiceImpl implements AgencyService {
    @Autowired
    AgencyRepository agencyRepository;

    @Autowired
    AgencyMapper agencyMapper;

    @Override
    public List<AgencyResponseDTO> getAll() {
        return agencyMapper.toResponseList(agencyRepository.findAll());
    }

    @Override
    public AgencyResponseDTO getById(UUID idAgency) {
        Agency agency = agencyRepository.findById(idAgency).orElseThrow();
        return agencyMapper.toResponse(agency);
    }

    @Override
    public AgencyResponseDTO save(AgencyResponseDTO agency) {
        return null;
    }

    @Override
    public AgencyResponseDTO update(UUID idAgency, AgencyResponseDTO agency) {
        return null;
    }

    @Override
    public void delete(UUID idAgency) {

    }

}
