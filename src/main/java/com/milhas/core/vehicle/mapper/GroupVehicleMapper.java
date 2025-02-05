package com.milhas.core.vehicle.mapper;

import com.milhas.core.vehicle.app.dto.response.GroupVehicleResponseDTO;
import com.milhas.core.vehicle.infra.db.entity.GroupVehicle;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class GroupVehicleMapper {
    public GroupVehicleResponseDTO toResponse(GroupVehicle vehicleGroup){
        return new GroupVehicleResponseDTO(vehicleGroup);
    }

    public List<GroupVehicleResponseDTO> toResponseList(List<GroupVehicle> vehicleGroup){
        return  vehicleGroup.stream().map(GroupVehicleResponseDTO::new).collect(Collectors.toList());
    }
}
