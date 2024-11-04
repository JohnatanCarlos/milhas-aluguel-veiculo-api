package com.milhas.core.vehicle.infra.db.repository;

import com.milhas.core.vehicle.infra.db.entity.VehicleGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface VehicleGroupRepository extends JpaRepository<VehicleGroup, UUID> {
}
