package com.milhas.core.vehicle.domain.service.impl;

import com.milhas.core.vehicle.app.dto.response.*;
import com.milhas.core.vehicle.domain.service.GroupVehicleService;
import com.milhas.core.vehicle.infra.db.entity.GroupVehicle;
import com.milhas.core.vehicle.infra.db.repository.GroupVehicleRepository;
import com.milhas.core.vehicle.mapper.GroupVehicleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class GroupVehicleServiceImpl implements GroupVehicleService {

    @Autowired
    GroupVehicleRepository vehicleGroupRepository;

    @Autowired
    GroupVehicleMapper groupVehicleMapper;

    @Override
    public List<GroupVehicleResponseDTO> findAll() {
        return groupVehicleMapper.toResponseList(vehicleGroupRepository.findAll());
    }

    @Override
    public GroupVehicleResponseDTO findById(UUID idVehicleGroup) {
        GroupVehicle vehicleGroup = vehicleGroupRepository.findById(idVehicleGroup).orElseThrow();
        return groupVehicleMapper.toResponse(vehicleGroup);
    }

    @Override
    public List<GroupVehicleAvailableDTO> findAvailableGroups(LocalDateTime dateDeparture, LocalDateTime dateReturn) {
        List<GroupVehicle> availableGroups = vehicleGroupRepository.findAvailableVehicleGroups(dateDeparture, dateReturn);

        return availableGroups.stream().map(vehicleGroup -> {
            return GroupVehicleAvailableDTO.builder()
                    .id(vehicleGroup.getId().toString())
                    .available(true)
                    .groupVehicle(GroupVehicleDTO.builder()
                            .category(vehicleGroup.getCategory())
                            .groupCode(vehicleGroup.getGroupCode())
                            .name(vehicleGroup.getName())
                            .vehicles(vehicleGroup.getVehicles().stream().map(vehicle -> VehicleResponseDTO.builder()
                                    .id(UUID.fromString(vehicle.getId().toString()))
                                    .brand(vehicle.getBrand())
                                    .model(vehicle.getModel())
                                    .yearManufacture(vehicle.getYearManufacture())
                                    .yearModel(vehicle.getYearModel())
                                    .chassis(vehicle.getChassis())
                                    .color(vehicle.getColor())
                                    .documentVehicle(vehicle.getDocumentVehicle())
                                    .plate(vehicle.getPlate())
                                    .power(vehicle.getPower())
                                    .build()
                            ).toList())
                            .build()
                    )
                    .tariff(TariffDTO.builder()
                            .value(vehicleGroup.getValue())
                            .build()
                    )
                    .build();
        }).toList();
    }
}
