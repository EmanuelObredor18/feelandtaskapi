package com.mikelauwrence.feelandtaskapi.models;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.Builder;
import lombok.Getter;

@Entity
@Table(name = "USERS")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString(exclude = {"password", "roles"})
public class UserEntity implements UserDetails {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false, unique = true)
  private String userCode;

  @Column(nullable = false, unique = true)
  private String username;

  @Column(nullable = false)
  private String password;
  
  @ManyToMany
  @JoinTable(name = "USER_ROLES", joinColumns = @JoinColumn(name = "user_id", nullable = false), inverseJoinColumns = @JoinColumn(name = "role_id", nullable = false))
  @Builder.Default
  private Set<Role> roles = new HashSet<>();

  @PrePersist
  private void prePersist() {
    this.userCode = generateUserCode();
  }

  private String generateUserCode() {
    
    String uuid = UUID.randomUUID().toString().substring(0, 8).toUpperCase();
    String createdAt = String.valueOf(System.currentTimeMillis()).substring(0, 8);

    return uuid + createdAt;
  }

  
  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    Set<SimpleGrantedAuthority> authorityList = new HashSet<>();

    this.roles.forEach(role -> authorityList.add(new SimpleGrantedAuthority("ROLE_".concat(role.getName().name()))));

    return authorityList;
  }
}
