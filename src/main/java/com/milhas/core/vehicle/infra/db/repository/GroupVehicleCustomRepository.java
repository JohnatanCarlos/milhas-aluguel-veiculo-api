package com.milhas.core.vehicle.infra.db.repository;

import com.milhas.core.vehicle.infra.db.entity.GroupVehicle;

import java.time.LocalDateTime;
import java.util.List;

public interface GroupVehicleCustomRepository {
    List<GroupVehicle> findAvailableVehicleGroups(LocalDateTime dateDeparture, LocalDateTime dateReturn);
}
