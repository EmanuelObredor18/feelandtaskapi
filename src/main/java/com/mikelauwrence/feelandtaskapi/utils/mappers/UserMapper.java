package com.mikelauwrence.feelandtaskapi.utils.mappers;

import java.util.Set;
import java.util.stream.Collectors;

import org.mapstruct.Mapper;

import com.mikelauwrence.feelandtaskapi.dto.CreateUserDTO;
import com.mikelauwrence.feelandtaskapi.dto.UserResponseDTO;
import com.mikelauwrence.feelandtaskapi.models.Role;
import com.mikelauwrence.feelandtaskapi.models.UserEntity;
import com.mikelauwrence.feelandtaskapi.models.enums.RoleEnum;

@Mapper(componentModel = "spring")
public interface UserMapper {
  
  UserResponseDTO toUserResponseDTO(UserEntity userEntity);

  // Ignore warning for the following method, the fields "id" and "userCode" are assigned automatically. 
  UserEntity toUserEntity(CreateUserDTO createUserDTO);

  default Set<Role> mapRoles(Set<RoleEnum> roleNames) {
    return roleNames.stream()
      .map(name -> Role.builder().name(name).build())
      .collect(Collectors.toSet());
  }
}
