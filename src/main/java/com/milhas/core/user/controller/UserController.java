package com.milhas.core.user.controller;

import com.milhas.core.user.app.dto.request.UserRequestDTO;
import com.milhas.core.user.app.dto.response.UserResponseDTO;
import com.milhas.core.user.domain.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<UserResponseDTO>> getAll(@RequestParam(required = false) String name,
                                                        @RequestParam(required = false) String documentNumber,
                                                        @RequestParam(required = false)  String nationality){
        return ResponseEntity.ok().body(userService.getAll(name, documentNumber, nationality));
    }

    @GetMapping(value = "/{idUser}")
    public ResponseEntity<UserResponseDTO> getById(@PathVariable UUID idUser){
        return ResponseEntity.ok().body(userService.getById(idUser));
    }

    @PostMapping
    public ResponseEntity<UserResponseDTO> save(@RequestBody UserRequestDTO request){
        return ResponseEntity.ok(userService.save(request));
    }

    @PutMapping(value = "/{idUser}")
    public ResponseEntity<UserResponseDTO> update(@PathVariable UUID idUser, @RequestBody UserRequestDTO request ){
        return ResponseEntity.ok().body(userService.update(idUser, request));
    }

    @DeleteMapping(value = "/{idUser}")
    public ResponseEntity<Void> delete(@PathVariable UUID idUser){
        userService.delete(idUser);
        return ResponseEntity.noContent().build(); // RETURN HTTP 204 NO CONTENT
    }

}
