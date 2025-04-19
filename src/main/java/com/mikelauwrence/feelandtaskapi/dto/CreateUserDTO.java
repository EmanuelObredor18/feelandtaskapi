package com.mikelauwrence.feelandtaskapi.dto;

import java.util.Set;

import com.mikelauwrence.feelandtaskapi.models.enums.RoleEnum;

public record CreateUserDTO(
  String username, 
  String password, 
  Set<RoleEnum> roles) {
  
}
