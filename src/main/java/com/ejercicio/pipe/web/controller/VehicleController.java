package com.ejercicio.pipe.web.controller;

import com.ejercicio.pipe.persistence.entity.User;
import com.ejercicio.pipe.persistence.entity.Vehicle;
import com.ejercicio.pipe.persistence.repository.UserRepository;
import com.ejercicio.pipe.persistence.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {

    @Autowired
    private VehicleRepository vehicleRepository;

    @Autowired
    private UserRepository userRepository;

    // ADMINISTRADOR: Crear un nuevo vehículo
    @PostMapping("/new")
    public ResponseEntity<Vehicle> createVehicle(@RequestBody Vehicle vehicle, @RequestParam Integer userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User  not found"));

        // Validaciones lógicas
        if (vehicle.getLicensePlate() == null || vehicle.getLicensePlate().length() > 6) {
            return ResponseEntity.badRequest().body(null); // Bad Request
        }

        vehicle.setEntryTime(LocalDateTime.now());
        return ResponseEntity.ok(vehicleRepository.save(vehicle));
    }

    // ADMINISTRADOR: Modificar vehículo
    @PutMapping("/{id}")
    public ResponseEntity<Vehicle> updateVehicle(@PathVariable Integer id, @RequestBody Vehicle vehicle, @RequestParam Integer userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User  not found"));

        Vehicle existingVehicle = vehicleRepository.findById(id).orElseThrow(() -> new RuntimeException("Vehicle not found"));

        // Validaciones lógicas
        if (vehicle.getLicensePlate() == null || vehicle.getLicensePlate().length() > 6) {
            return ResponseEntity.badRequest().body(null); // Bad Request
        }

        existingVehicle.setLicensePlate(vehicle.getLicensePlate());
        existingVehicle.setLocation(vehicle.getLocation());
        existingVehicle.setVehicleType(vehicle.getVehicleType());
        return ResponseEntity.ok(vehicleRepository.save(existingVehicle));
    }

    // ADMINISTRADOR: Eliminar vehículo
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVehicle(@PathVariable Integer id, @RequestParam Integer userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User  not found"));

        vehicleRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    // CLIENTE: Ver todos los vehículos
    @GetMapping
    public ResponseEntity<List<Vehicle>> getAllVehicles() {
        return ResponseEntity.ok(vehicleRepository.findAll());
    }

    // ACOMODADOR: Actualizar ubicación de un vehículo
    @PatchMapping("/{id}/location")
    public ResponseEntity<Vehicle> updateVehicleLocation(@PathVariable Integer id, @RequestParam String location, @RequestParam Integer userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User  not found"));

        Vehicle vehicle = vehicleRepository.findById(id).orElseThrow(() -> new RuntimeException("Vehicle not found"));
        vehicle.setLocation(location);
        return ResponseEntity.ok(vehicleRepository.save(vehicle));
    }
}