package com.milhas.core.vehicle.infra.db.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "group_vehicle")
public class VehicleGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_group_vehicle", nullable = false, unique = true)
    private UUID id;

    @OneToMany(mappedBy = "vehicleGroup", fetch = FetchType.LAZY)
    private List<Vehicle> vehicles;

//    @OneToMany(mappedBy = "optionalVehicle", fetch = FetchType.LAZY)
//    private List<OptionalVehicle> optional;

    @Column(name = "group_code", nullable = false)
    private String groupCode;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "category", nullable = false)
    private String category;

    @Column(name = "value")
    private Double value;

    @Column(name = "create_date", nullable = false)
    private LocalDateTime createDate = LocalDateTime.now();

    @Column(name = "update_date")
    private LocalDateTime updateDate = LocalDateTime.now();

    @Column(name = "is_active", nullable = false)
    private Boolean isActive = true;

    @Builder
    public VehicleGroup(String groupCode, String name, String category, Double value) {
        this.groupCode = groupCode;
        this.name = name;
        this.category = category;
        this.value = value;
    }
}
