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
}