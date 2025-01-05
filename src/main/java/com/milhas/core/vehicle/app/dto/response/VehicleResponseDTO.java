package com.milhas.core.vehicle.app.dto.response;

import com.milhas.core.vehicle.infra.db.entity.Vehicle;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
public class VehicleResponseDTO {
    private UUID id;
    private String brand;
    private String model;
    private LocalDateTime yearManufacture;
    private LocalDateTime yearModel;
    private String chassis;
    private String color;
    private String documentVehicle;
    private String plate;
    private Double power;

}
