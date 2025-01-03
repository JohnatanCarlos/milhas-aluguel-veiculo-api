package com.milhas.core.vehicle.app.dto.response;

import com.milhas.core.vehicle.infra.db.entity.VehicleGroup;
import lombok.Data;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Data
public class VehicleGroupResponseDTO {
    private UUID id;
    private String groupCode;
    private String name;
    private String category;
    private Double value;
    private List<VehicleResponseDTO> vehicles;


    public VehicleGroupResponseDTO(VehicleGroup vehicleGroup) {
        this.id = vehicleGroup.getId();
        this.groupCode = vehicleGroup.getGroupCode();
        this.name = vehicleGroup.getName();
        this.category = vehicleGroup.getCategory();
        this.value = vehicleGroup.getValue();

        this.vehicles = vehicleGroup.getVehicles().stream()
                .map(VehicleResponseDTO::new)
                .collect(Collectors.toList());

    }
}
