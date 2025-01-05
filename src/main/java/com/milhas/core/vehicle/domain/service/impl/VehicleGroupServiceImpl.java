package com.milhas.core.vehicle.domain.service.impl;

import com.milhas.core.vehicle.app.dto.response.*;
import com.milhas.core.vehicle.domain.service.VehicleGroupService;
import com.milhas.core.vehicle.infra.db.entity.VehicleGroup;
import com.milhas.core.vehicle.infra.db.repository.VehicleGroupRepository;
import com.milhas.core.vehicle.mapper.VehicleGroupMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class VehicleGroupServiceImpl implements VehicleGroupService {

    @Autowired
    VehicleGroupRepository vehicleGroupRepository;

    @Autowired
    VehicleGroupMapper vehicleGroupMapper;

    @Override
    public List<VehicleGroupResponseDTO> findAll() {
        return vehicleGroupMapper.toResponseList(vehicleGroupRepository.findAll());
    }

    @Override
    public VehicleGroupResponseDTO findById(UUID idVehicleGroup) {
        VehicleGroup vehicleGroup = vehicleGroupRepository.findById(idVehicleGroup).orElseThrow();
        return vehicleGroupMapper.toResponse(vehicleGroup);
    }

    @Override
    public List<AvailableVehicleGroupDTO> findAvailableGroups(LocalDateTime dateDeparture, LocalDateTime dateReturn) {
        List<VehicleGroup> availableGroups = vehicleGroupRepository.findAvailableVehicleGroups(dateDeparture, dateReturn);

        return availableGroups.stream().map(vehicleGroup -> {
            return AvailableVehicleGroupDTO.builder()
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
