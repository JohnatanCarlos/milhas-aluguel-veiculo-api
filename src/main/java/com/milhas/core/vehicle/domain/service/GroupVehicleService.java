package com.milhas.core.vehicle.domain.service;

import com.milhas.core.vehicle.app.dto.response.GroupVehicleAvailableDTO;
import com.milhas.core.vehicle.app.dto.response.GroupVehicleResponseDTO;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public interface GroupVehicleService {
    public List<GroupVehicleResponseDTO> findAll();

    public GroupVehicleResponseDTO findById(UUID idVehicleGroup);

    public List<GroupVehicleAvailableDTO> findAvailableGroups(LocalDateTime dateDeparture, LocalDateTime dateReturn);
}
