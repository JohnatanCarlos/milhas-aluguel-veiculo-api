package com.milhas.core.vehicle.controller;

import com.milhas.core.commons.dto.Response;
import com.milhas.core.vehicle.app.dto.response.GroupVehicleAvailableDTO;
import com.milhas.core.vehicle.app.dto.response.GroupVehicleResponseDTO;
import com.milhas.core.vehicle.domain.service.GroupVehicleService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/vehicle/group")
public class GroupVehicleController {
    @Autowired
    GroupVehicleService vehicleGroupService;

    @GetMapping()
    public Response<List<GroupVehicleResponseDTO>> getAll() {
        return new Response<>(vehicleGroupService.findAll());
    }

    @GetMapping(value = "/{idVehicleGroup}")
    public Response<GroupVehicleResponseDTO> getById(@PathVariable UUID idVehicleGroup) {
        return new Response<>(vehicleGroupService.findById(idVehicleGroup));
    }

    @GetMapping(value = "/available")
    public Response<List<GroupVehicleAvailableDTO>> getAvailableGroups(
            @RequestParam(required = true) LocalDateTime dateDeparture,
            @RequestParam(required = true) LocalDateTime dateReturn
    ) {
        List<GroupVehicleAvailableDTO> availableGroups = vehicleGroupService.findAvailableGroups(dateDeparture, dateReturn);
        return new Response<>(availableGroups);
    }

}
