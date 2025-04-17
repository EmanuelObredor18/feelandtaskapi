package com.mikelauwrence.feelandtaskapi.dto;

public record TaskResponseDTO(
    Long id,
    String title,
    String description,
    String status,
    String priority,
    String dueDate,
    String createdAt) {
  
}
