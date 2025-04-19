package com.mikelauwrence.feelandtaskapi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mikelauwrence.feelandtaskapi.models.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
  
  Optional<UserEntity> findByUsername(String username);
  
  Optional<UserEntity> findByUserCode(String userCode);
  
  Optional<UserEntity> findByUsernameAndPassword(String username, String password);

  boolean existsByUsername(String username);
  
  boolean existsByUserCode(String userCode);
  
  boolean existsById(Long id);
  
}
