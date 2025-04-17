package com.mikelauwrence.feelandtaskapi.dto;

import lombok.Builder;

@Builder
public record CreateTaskDTO(
    String title,
    String description,
    String status,
    String priority,
    String dueDate) {
  
}
