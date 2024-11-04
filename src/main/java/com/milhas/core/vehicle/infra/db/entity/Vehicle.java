package com.milhas.core.vehicle.infra.db.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "vehicle")
public class Vehicle {
    @Id
    @Column(name = "id_vehicle", nullable = false, unique = true)
    private UUID id;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_group_vehicle", nullable = false)
    private VehicleGroup vehicleGroup;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "id_optional_vehicle", nullable = false)
//    private OptionalVehicle optionalVehicle;

    @Column(name = "brand", nullable = false)
    private String brand;

    @Column(name = "model", nullable = false)
    private String model;

    @Column(name = "year_manufacture", nullable = false)
    private LocalDateTime yearManufacture;

    @Column(name = "year_model", nullable = false)
    private LocalDateTime yearModel;

    @Column(name = "chassis", nullable = false)
    private String chassis;

    @Column(name = "color", nullable = false)
    private String color;

    @Column(name = "document_vehicle", nullable = false)
    private String documentVehicle;

    @Column(name = "plate", nullable = false)
    private String plate;

    @Column(name = "power", nullable = false)
    private Double power;

    @Column(name = "create_date", nullable = false)
    private LocalDateTime createDate = LocalDateTime.now();

    @Column(name = "update_date")
    private LocalDateTime updateDate = LocalDateTime.now();

    @Column(name = "is_active", nullable = false)
    private Boolean isActive = true;

    @Builder
    public Vehicle(
            String brand,
            String model,
            LocalDateTime yearManufacture,
            LocalDateTime yearModel,
            String chassis,
            String color,
            String documentVehicle,
            String plate,
            Double power
    ){
        this.brand = brand;
        this.model = model;
        this.yearManufacture = yearManufacture;
        this.yearModel =  yearModel;
        this.chassis = chassis;
        this.color = color;
        this.documentVehicle = documentVehicle;
        this.plate = plate;
        this.power = power;
    }

}
