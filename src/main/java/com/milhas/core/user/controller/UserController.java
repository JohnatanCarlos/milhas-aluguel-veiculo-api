package com.milhas.core.user.controller;

import com.milhas.core.commons.dto.Response;
import com.milhas.core.user.app.dto.request.UserRequestDTO;
import com.milhas.core.user.app.dto.response.UserResponseDTO;
import com.milhas.core.user.domain.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/users")
@RequiredArgsConstructor
public class UserController {

    @Inject
    UserService userService;
    
    @GetMapping
    @Operation(summary = "User", description = "Retorna todos os usuários podendo ser usado como filtro atraves dos parametros")
    public Response<List<UserResponseDTO>> getAll(@RequestParam(required = false) String name,
                                                  @RequestParam(required = false) String documentNumber,
                                                  @RequestParam(required = false)  String nationality,
                                                  @RequestParam(required = false) String passport ){
        return new Response<>(userService.getAll(name, documentNumber, nationality, passport), userService.getAll(name, documentNumber, nationality, passport).size());
    }

    @GetMapping(value = "/{idUser}")
    public Response<UserResponseDTO> getById(@PathVariable UUID idUser){
        return new Response<>(userService.getById(idUser));
    }

    @PostMapping
    public Response<UserResponseDTO> save(@RequestBody UserRequestDTO request){
        return new Response<>(userService.save(request));
    }

    @PutMapping(value = "/{idUser}")
    public Response<UserResponseDTO> update(@PathVariable UUID idUser, @RequestBody UserRequestDTO request ){
        return new Response<>(userService.update(idUser, request));
    }

    @DeleteMapping(value = "/{idUser}")
    public Response<Void> delete(@PathVariable UUID idUser){
        userService.delete(idUser);
        return new Response<>();
    }

}
