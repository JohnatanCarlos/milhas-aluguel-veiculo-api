package com.milhas.core.user.domain.service.impl;

import com.milhas.core.user.app.dto.request.UserRequestDTO;
import com.milhas.core.user.app.dto.response.UserResponseDTO;
import com.milhas.core.user.domain.service.UserService;
import com.milhas.core.user.infra.db.entity.User;
import com.milhas.core.user.infra.db.entity.UserCredential;
import com.milhas.core.user.infra.db.repository.UserCredentialRepository;
import com.milhas.core.user.infra.db.repository.UserRepository;
import com.milhas.core.user.mapper.UserMapper;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@Primary
public class UserServiceImpl implements UserService {

    @Inject
    UserRepository userRepository;

    @Inject
    UserMapper userMapper;

    @Inject
    UserCredentialRepository userCredentialRepository;


    @Override
    public List<UserResponseDTO> getAll(String name, String documentNumber, String nationality ) {
        return userMapper.toResponseList(userRepository.findAllCustom( name, documentNumber, nationality));
    }

    @Override
    public UserResponseDTO getById(UUID idUser) {
        User user = returnUserById(idUser);
        return userMapper.toResponse(user);
    }

    @Transactional
    public UserResponseDTO save(UserRequestDTO requestDTO) {
        UserCredential userCredential = new UserCredential();
        userCredential.setPassword(requestDTO.getPassword());
        userCredential = userCredentialRepository.save(userCredential);

        User user = userMapper.toEntity(requestDTO);
        user.setUserCredential(userCredential);
        return userMapper.toResponse(userRepository.save(user));
    }

    @Transactional
    public UserResponseDTO update(UUID idUser, UserRequestDTO request) {
        User user = returnUserById(idUser);
        user.setUpdateDate(LocalDateTime.now());
        userMapper.toResponseUpdate(user, request);
        return  userMapper.toResponse(userRepository.save(user));
    }

    @Override
    public void delete(UUID idUser) {
        User user = returnUserById(idUser);
        userRepository.deleteById(idUser);
        userCredentialRepository.deleteById(user.getUserCredential().getIdCredential());
    }

    private User returnUserById(UUID idUser){
        return userRepository.findById(idUser).orElseThrow(()-> new RuntimeException("User was not found"));
    }
}
