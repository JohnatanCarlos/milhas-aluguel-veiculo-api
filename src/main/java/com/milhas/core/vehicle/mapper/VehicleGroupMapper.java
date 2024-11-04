package com.milhas.core.vehicle.mapper;

import com.milhas.core.vehicle.app.dto.response.VehicleGroupResponseDTO;
import com.milhas.core.vehicle.infra.db.entity.VehicleGroup;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class VehicleGroupMapper {
    public VehicleGroupResponseDTO toResponse(VehicleGroup vehicleGroup){
        return new VehicleGroupResponseDTO(vehicleGroup);
    }

    public List<VehicleGroupResponseDTO> toResponseList(List<VehicleGroup> vehicleGroup){
        return  vehicleGroup.stream().map(VehicleGroupResponseDTO::new).collect(Collectors.toList());
    }
}
