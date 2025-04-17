package com.mikelauwrence.feelandtaskapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mikelauwrence.feelandtaskapi.models.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {
  
  // TODO: implement this method to find all tasks by user
  // Task findAllByUser(UserEntity user);
}
