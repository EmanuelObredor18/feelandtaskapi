package com.mikelauwrence.feelandtaskapi.dto;

import java.util.Set;

public record CreateUserDTO(
  String username, 
  String password, 
  String userCode, 
  Set<String> roles) {
  
}
