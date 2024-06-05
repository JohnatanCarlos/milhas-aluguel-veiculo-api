package com.milhas.core.user.domain.service;

import com.milhas.core.user.app.dto.request.UserRequestDTO;
import com.milhas.core.user.app.dto.response.UserResponseDTO;

import java.util.List;
import java.util.UUID;

public interface UserService {

    List<UserResponseDTO> getAll(String name, String documentNumber, String nationality);

    UserResponseDTO getById(UUID idUser);

    UserResponseDTO save(UserRequestDTO request);

    UserResponseDTO update(UUID idUser, UserRequestDTO request);

    void delete(UUID idUser);
}
