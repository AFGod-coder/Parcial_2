package com.ejercicio.pipe.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "vehicle_types")
@Getter
@Setter
@NoArgsConstructor
public class VehicleType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vehicle_type_id", nullable = false)
    private Integer vehicleTypeId;

    @Column(name = "type_name", nullable = false, unique = true)
    private String typeName; // Nombre del tipo de vehículo (ej. "Carro", "Moto", etc.)

    // Otros atributos y métodos según sea necesario
}