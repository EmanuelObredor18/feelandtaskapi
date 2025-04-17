package com.mikelauwrence.feelandtaskapi.service.impl;

import org.springframework.stereotype.Service;

import com.mikelauwrence.feelandtaskapi.dto.CreateTaskDTO;
import com.mikelauwrence.feelandtaskapi.dto.TaskResponseDTO;
import com.mikelauwrence.feelandtaskapi.repository.TaskRepository;
import com.mikelauwrence.feelandtaskapi.service.TaskService;
import com.mikelauwrence.feelandtaskapi.utils.mappers.TaskMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

  private final TaskRepository taskRepository;
  private final TaskMapper taskMapper;

  @Override
  public TaskResponseDTO createTask(CreateTaskDTO createTaskDTO) {
    return taskMapper.toTaskResponseDTO(
        taskRepository.save(taskMapper.toTask(createTaskDTO)));
  }

  @Override
  public String deleteTask(Long id) {
    
    if (!taskRepository.existsById(id)) return "Task not found";
    
    taskRepository.deleteById(id);
    return "Task deleted successfully";

  }

  @Override
  public TaskResponseDTO getTaskById(Long id) {
    return taskMapper.toTaskResponseDTO(
        taskRepository.findById(id).orElseThrow(() -> new RuntimeException("Task not found")));
  }

  @Override
  public TaskResponseDTO updateTask(Long id, CreateTaskDTO createTaskDTO) {
    if (!taskRepository.existsById(id)) return null;
    
    return taskMapper.toTaskResponseDTO(
        taskRepository.save(taskMapper.toTask(createTaskDTO)));
  }
  
}
