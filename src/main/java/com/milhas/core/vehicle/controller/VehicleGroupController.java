package com.milhas.core.vehicle.controller;

import com.milhas.core.commons.dto.Response;
import com.milhas.core.vehicle.app.dto.response.AvailableVehicleGroupDTO;
import com.milhas.core.vehicle.app.dto.response.VehicleGroupResponseDTO;
import com.milhas.core.vehicle.domain.service.VehicleGroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/vehicle/group")
public class VehicleGroupController {
    @Autowired
    VehicleGroupService vehicleGroupService;

    @GetMapping()
    public Response<List<VehicleGroupResponseDTO>> getAll() {
        return new Response<>(vehicleGroupService.findAll());
    }

    @GetMapping(value = "/{idVehicleGroup}")
    public Response<VehicleGroupResponseDTO> getById(@PathVariable UUID idVehicleGroup) {
        return new Response<>(vehicleGroupService.findById(idVehicleGroup));
    }

    @GetMapping(value = "/available")
    public Response<List<AvailableVehicleGroupDTO>> getAvailableGroups(
            @RequestParam(required = true) LocalDateTime dateDeparture,
            @RequestParam(required = true) LocalDateTime dateReturn
    ) {
        List<AvailableVehicleGroupDTO> availableGroups = vehicleGroupService.findAvailableGroups(dateDeparture, dateReturn);
        return new Response<>(availableGroups);
    }

}
