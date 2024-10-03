package com.milhas.core.user.domain.service.impl;

import com.milhas.core.commons.exception.UserNotFoundException;
import com.milhas.core.user.app.dto.request.UserRequestDTO;
import com.milhas.core.user.app.dto.response.UserResponseDTO;
import com.milhas.core.user.domain.service.UserService;
import com.milhas.core.user.infra.db.entity.User;
import com.milhas.core.user.infra.db.entity.UserCredential;
import com.milhas.core.user.infra.db.repository.UserCredentialRepository;
import com.milhas.core.user.infra.db.repository.UserRepository;
import com.milhas.core.user.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@Primary
public class UserServiceImpl implements UserService, UserDetailsService {

    @Inject
    UserRepository userRepository;

    @Inject
    UserMapper userMapper;

    @Inject
    UserCredentialRepository userCredentialRepository;

    @Autowired
    PasswordEncoder passwordEncoder;


    @Override
    public List<UserResponseDTO> getAll(String name, String documentNumber, String nationality, String passport ) {
        return userMapper.toResponseList(userRepository.findAllCustom( name, documentNumber, nationality, passport));
    }

    @Override
    public UserResponseDTO getById(UUID idUser) {
        User user = userRepository.findById(idUser).orElseThrow(()-> new UserNotFoundException());
        return userMapper.toResponse(user);
    }

    @Transactional
    public UserResponseDTO save(UserRequestDTO requestDTO) {
        UserCredential userCredential = new UserCredential();
        userCredential.setPassword(passwordEncoder.encode(requestDTO.getPassword()));

        User user = userMapper.toEntity(requestDTO);
        user.setUserCredential(userCredential);
        return userMapper.toResponse(userRepository.save(user));
    }

    @Transactional
    public UserResponseDTO update(UUID idUser, UserRequestDTO request) {
        User user = userRepository.findById(idUser).orElseThrow(()-> new RuntimeException("User was not found"));
        user.setUpdateDate(LocalDateTime.now());
        userMapper.toResponseUpdate(user, request);
        return  userMapper.toResponse(userRepository.save(user));
    }

    @Override
    public void delete(UUID idUser) {
        userRepository.deleteById(idUser);
    }

    //TODO: TRANSFORMAR ISSO EM UM NOVO SERVICE CHAMADO AuthorizationService
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByEmail(username);
    }
}
