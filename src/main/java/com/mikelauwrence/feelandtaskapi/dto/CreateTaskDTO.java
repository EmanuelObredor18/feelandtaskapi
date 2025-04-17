package com.mikelauwrence.feelandtaskapi.dto;

import java.time.LocalDateTime;

import com.mikelauwrence.feelandtaskapi.models.enums.Priority;
import com.mikelauwrence.feelandtaskapi.models.enums.Status;

import lombok.Builder;

@Builder
public record CreateTaskDTO(
    String title,
    String description,
    Status status,
    Priority priority,
    LocalDateTime dueDate) {
  
}
