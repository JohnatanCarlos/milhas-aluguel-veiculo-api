package com.milhas.core.vehicle.app.dto.response;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GroupVehicleAvailableDTO {
    private String id;
    private boolean available;
    private GroupVehicleDTO groupVehicle;
    private TariffDTO tariff;
}
