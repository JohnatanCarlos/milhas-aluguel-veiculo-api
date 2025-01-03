package com.milhas.core.agency.controller;

import com.milhas.core.agency.app.dto.response.AgencyResponseDTO;
import com.milhas.core.agency.domain.service.AgencyService;
import com.milhas.core.commons.dto.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/agency")
@RequiredArgsConstructor
public class AgencyController {
    @Autowired
    AgencyService agencyService;

    @GetMapping
    public Response<List<AgencyResponseDTO>> getAll(@RequestParam(required = false) String name) {
        return new Response<>(agencyService.getAll(name));
    }

    @GetMapping(value = "/{idAgency}")
    public Response<AgencyResponseDTO> getById(@PathVariable UUID idAgency) {
        return new Response<>(agencyService.getById(idAgency));
    }
}
