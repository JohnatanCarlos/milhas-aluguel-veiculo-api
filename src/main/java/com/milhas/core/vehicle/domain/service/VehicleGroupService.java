package com.milhas.core.vehicle.domain.service;

import com.milhas.core.vehicle.app.dto.response.AvailableVehicleGroupDTO;
import com.milhas.core.vehicle.app.dto.response.VehicleGroupResponseDTO;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public interface VehicleGroupService {
    public List<VehicleGroupResponseDTO> findAll();

    public VehicleGroupResponseDTO findById(UUID idVehicleGroup);

    public List<AvailableVehicleGroupDTO> findAvailableGroups(LocalDateTime dateDeparture, LocalDateTime dateReturn);
}
