package com.fullstack.vehicles.repositories;

import com.fullstack.vehicles.domain.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Integer> {

    //Se quiser alguma query específica, usemos essa classe. Ex.:
    //@Query("SELECT obj FROM Vehicle obj ORDER BY obj.model")
    //List<Vehicle> findAll();
}
