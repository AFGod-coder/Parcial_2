package com.ejercicio.pipe.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "user_roles")
@Getter
@Setter
@NoArgsConstructor
public class UserRole {
    @Id
    @Column(name = "user_id") // Mapeo de columna
    private Integer userId;

    @Id
    @Column(name = "role_id") // Cambiado de role_name a role_id
    private Integer roleId; // Cambiado de String a Integer

    @Column(name = "granted_date", nullable = true, columnDefinition = "DATETIME")
    private LocalDateTime grantedDate;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", insertable = false, updatable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "role_id", referencedColumnName = "role_id", insertable = false, updatable = false)
    private Role role;
}