package com.milhas.core.vehicle.app.dto.response;

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

    public VehicleResponseDTO(UUID id, String brand, String model, LocalDateTime yearManufacture,
                              LocalDateTime yearModel, String chassis, String color,
                              String documentVehicle, String plate, Double power) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.yearManufacture = yearManufacture;
        this.yearModel = yearModel;
        this.chassis = chassis;
        this.color = color;
        this.documentVehicle = documentVehicle;
        this.plate = plate;
        this.power = power;
    }

}
