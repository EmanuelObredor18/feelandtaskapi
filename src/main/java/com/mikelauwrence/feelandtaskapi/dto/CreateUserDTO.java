package com.mikelauwrence.feelandtaskapi.dto;

import java.util.Set;

public record CreateUserDTO(
  String username, 
  String password, 
  Set<String> roles) {
  
}
