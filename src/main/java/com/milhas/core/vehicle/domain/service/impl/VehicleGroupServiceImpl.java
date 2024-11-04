package com.milhas.core.vehicle.domain.service.impl;

import com.milhas.core.vehicle.app.dto.response.VehicleGroupResponseDTO;
import com.milhas.core.vehicle.domain.service.VehicleGroupService;
import com.milhas.core.vehicle.infra.db.entity.VehicleGroup;
import com.milhas.core.vehicle.infra.db.repository.VehicleGroupRepository;
import com.milhas.core.vehicle.mapper.VehicleGroupMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class VehicleGroupServiceImpl implements VehicleGroupService {

    @Autowired
    VehicleGroupRepository vehicleGroupRepository;

    @Autowired
    VehicleGroupMapper vehicleGroupMapper;

    @Override
    public List<VehicleGroupResponseDTO> findAll() {
        return vehicleGroupMapper.toResponseList(vehicleGroupRepository.findAll());
    }

    @Override
    public VehicleGroupResponseDTO findById(UUID idVehicleGroup) {
        VehicleGroup vehicleGroup = vehicleGroupRepository.findById(idVehicleGroup).orElseThrow();
        return vehicleGroupMapper.toResponse(vehicleGroup);
    }
}
