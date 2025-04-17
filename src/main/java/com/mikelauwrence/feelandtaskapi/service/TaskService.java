package com.mikelauwrence.feelandtaskapi.service;

import com.mikelauwrence.feelandtaskapi.dto.CreateTaskDTO;
import com.mikelauwrence.feelandtaskapi.dto.TaskResponseDTO;

public interface TaskService {

  TaskResponseDTO createTask(CreateTaskDTO createTaskDTO);

  String deleteTask(Long id);

  TaskResponseDTO getTaskById(Long id);

  TaskResponseDTO updateTask(Long id, CreateTaskDTO createTaskDTO);

  // TODO: Implement the method to get a task by its ID and user ID
  // TaskResponseDTO getTaskByIdAndUserId(Long id, Long userId);

  // TODO: Implement the method to get all tasks by user ID
  // Set<TaskResponseDTO> getAllTasksByUserId(Long userId);
}
