package com.milhas.core.user.mapper;

import com.milhas.core.user.app.dto.request.UserRequestDTO;
import com.milhas.core.user.app.dto.response.UserResponseDTO;
import com.milhas.core.user.infra.db.entity.User;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMapper {

//    DTO PARA ENTITY
    public User toEntity(UserRequestDTO request){
        return User.builder()
                .name(request.getName())
                .documentNumber(request.getDocumentNumber())
                .documentType(request.getDocumentType())
                .nationality(request.getNationality())
                .phone(request.getPhone())
                .email(request.getEmail())
                .dateBirthday(request.getDateBirthday())
                .build();
    }

//    ENTITY PARA DTO
    public UserResponseDTO toResponse(User user){
        return new UserResponseDTO(user);
    }

//    LISTA DE ENTITY PARA DTO
    public List<UserResponseDTO> toResponseList(List<User> userList){
        return  userList.stream().map(UserResponseDTO::new).collect(Collectors.toList());
    }

//    ATUALIZA DADOS DE PERSON
    public void toResponseUpdate(User user, UserRequestDTO request){
        user.setName(request.getName());
        user.setDocumentNumber(request.getDocumentNumber());
        user.setDocumentType(request.getDocumentType());
        user.setNationality(request.getNationality());
        user.setPhone(request.getPhone());
        user.setEmail(user.getEmail());
        user.setDateBirthday(request.getDateBirthday());
    }
}
