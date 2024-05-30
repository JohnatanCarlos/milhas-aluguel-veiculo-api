package com.milhas.core.user.domain.service.impl;

import com.milhas.core.user.app.dto.request.UserRequestDTO;
import com.milhas.core.user.app.dto.response.UserResponseDTO;
import com.milhas.core.user.domain.service.UserService;
import com.milhas.core.user.infra.db.entity.User;
import com.milhas.core.user.infra.db.repository.UserRepository;
import com.milhas.core.user.mapper.UserMapper;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;
import java.util.UUID;

@Service
@Primary
public class UserServiceImpl implements UserService {

    @Inject
    UserRepository userRepository;

    @Inject
    UserMapper userMapper;


    @Override
    public List<UserResponseDTO> getAll(String name, String documentNumber, String nationality, String passport ) {
        return userMapper.toResponseList(userRepository.findAll());
    }

    @Override
    public UserResponseDTO getById(UUID idUser) {
        User user = userRepository.findById(idUser).orElseThrow(()-> new RuntimeException("User was not found"));
        return userMapper.toResponse(user);
    }

    @Override
    public UserResponseDTO save(UserRequestDTO request) {
        User user = userMapper.toEntity(request);
        return userMapper.toResponse(userRepository.save(user));
    }

    @Override
    public UserResponseDTO update(UUID idUser, UserRequestDTO request) {
        User user = userRepository.findById(idUser).orElseThrow(()-> new RuntimeException("User was not found"));
        userMapper.toResponseUpdate(user, request);
        return  userMapper.toResponse(userRepository.save(user));
    }

    @Override
    public void delete(UUID idUser) {
        userRepository.deleteById(idUser);
    }
}
