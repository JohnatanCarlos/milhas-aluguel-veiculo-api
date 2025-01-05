package com.milhas.core.vehicle.infra.db.repository;

import com.milhas.core.vehicle.infra.db.entity.VehicleGroup;

import java.time.LocalDateTime;
import java.util.List;

public interface VehicleGroupCustomRepository {
    List<VehicleGroup> findAvailableVehicleGroups(LocalDateTime dateDeparture, LocalDateTime dateReturn);
}
