package com.ejercicio.pipe.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "user")
@Getter
@Setter
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", nullable = false) //Asi esta en mi base de datos
    private Integer userId; //Asi va a estar en mi codigo

    private String username;
    private String password;
    private String email;

}
