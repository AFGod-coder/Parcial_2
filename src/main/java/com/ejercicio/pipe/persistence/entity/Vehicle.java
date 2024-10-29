package com.ejercicio.pipe.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "vehicles")
@Getter
@Setter
@NoArgsConstructor
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vehicle_id", nullable = false)
    private Integer vehicleId;

    @Column(name = "license_plate", nullable = false, length = 6, unique = true)
    private String licensePlate; // Placa del vehículo

    @Column(name = "entry_time", nullable = false)
    private LocalDateTime entryTime; // Hora de entrada

    @Column(name = "exit_time")
    private LocalDateTime exitTime; // Hora de salida

    @Column(name = "location", nullable = false)
    private String location; // Ubicación asignada

    @ManyToOne
    @JoinColumn(name = "vehicle_type_id", nullable = false)
    private VehicleType vehicleType; // Tipo de vehículo

    // Otros atributos y métodos según sea necesario
}