package com.milhas.core.agency.infra.db.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
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

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "phone", nullable = false)
    private String phone;

    @Column(name = "create_date", nullable = false)
    private LocalDateTime createDate = LocalDateTime.now();

    @Column(name = "update_date")
    private LocalDateTime updateDate = LocalDateTime.now();

    @Column(name = "is_active", nullable = false)
    private Boolean isActive = true;

    @Builder
    public Agency(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

}
