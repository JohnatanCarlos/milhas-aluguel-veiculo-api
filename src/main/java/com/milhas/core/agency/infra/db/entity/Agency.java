package com.milhas.core.agency.infra.db.entity;

import com.milhas.core.vehicle.infra.db.entity.GroupVehicle;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "agency")

public class Agency {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_agency", unique = true, nullable = false)
    private UUID id;

    @OneToOne
    @JoinColumn(name = "id_address", nullable = false)
    private Address address;

    @ManyToMany
    @JoinTable(
            name = "agency_group_vehicle",
            joinColumns = @JoinColumn(name = "id_agency"),
            inverseJoinColumns = @JoinColumn(name = "id_group_vehicle")
    )
    private List<GroupVehicle> groups;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "code", nullable = false)
    private String code;

    @Column(name = "phone", nullable = false)
    private String phone;

    @Column(name = "create_date", nullable = false)
    private LocalDateTime createDate = LocalDateTime.now();

    @Column(name = "update_date")
    private LocalDateTime updateDate = LocalDateTime.now();

    @Column(name = "is_active", nullable = false)
    private Boolean isActive = true;

    @Builder
    public Agency(String name, String code, String phone, List<GroupVehicle> groups) {
        this.name = name;
        this.code = code;
        this.phone = phone;
        this.groups = groups;
    }

}
