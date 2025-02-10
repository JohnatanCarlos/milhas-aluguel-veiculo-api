package com.milhas.core.vehicle.app.dto.response;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class GroupVehicleDTO {
    private String category;
    private String groupCode;
    private String name;
    private List<VehicleResponseDTO> vehicles;

    public GroupVehicleDTO(String category, String name, String groupCode, List<VehicleResponseDTO> vehicles) {
        this.name = name;
        this.category = category;
        this.groupCode = groupCode;
        this.vehicles = vehicles;
    }
}