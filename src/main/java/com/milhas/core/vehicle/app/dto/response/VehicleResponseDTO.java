package com.milhas.core.vehicle.app.dto.response;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
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

//    public VehicleResponseDTO(Vehicle vehicle) {
//        this.id = vehicle.getId();
//        this.brand = vehicle.getBrand();
//        this.model = vehicle.getModel();
//        this.yearManufacture = vehicle.getYearManufacture();
//        this.yearModel = vehicle.getYearModel();
//        this.chassis = vehicle.getChassis();
//        this.color = vehicle.getColor();
//        this.documentVehicle = vehicle.getDocumentVehicle();
//        this.plate = vehicle.getPlate();
//        this.power = vehicle.getPower();
//    }
}
