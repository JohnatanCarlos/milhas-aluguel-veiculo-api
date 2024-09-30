package com.milhas.core.authentication.controller;

import com.milhas.core.commons.dto.Response;
import com.milhas.core.authentication.app.dto.request.AutheticationRequestDTO;
import com.milhas.core.authentication.app.dto.request.LoginResponseDTO;
import com.milhas.core.authentication.domain.service.impl.TokenService;
import com.milhas.core.user.infra.db.entity.User;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public Response<LoginResponseDTO> login(@RequestBody @Valid AutheticationRequestDTO body){
        var usernamePassword = new UsernamePasswordAuthenticationToken(body.email(), body.password());
        var auth = this.authenticationManager.authenticate(usernamePassword);
        var token = tokenService.generateToken((User) auth.getPrincipal());

        return new Response<>(new LoginResponseDTO(token));
    }
}
