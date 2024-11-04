package com.milhas.core.vehicle.controller;

import com.milhas.core.commons.dto.Response;
import com.milhas.core.vehicle.app.dto.response.VehicleGroupResponseDTO;
import com.milhas.core.vehicle.domain.service.VehicleGroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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



}
