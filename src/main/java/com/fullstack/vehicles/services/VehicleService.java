package com.fullstack.vehicles.services;

import com.fullstack.vehicles.domain.Vehicle;
import com.fullstack.vehicles.repositories.VehicleRepository;
import com.fullstack.vehicles.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleService {

    @Autowired
    private VehicleRepository repository;

    public Vehicle findById(Integer id) {
        Optional<Vehicle> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto nao encontrado. Id: " + id));
    }

    public List<Vehicle> findAll() {
        List<Vehicle> list = repository.findAll();
        return list;
    }

    public Vehicle create(Vehicle obj) {
        obj.setId(null);
        return repository.save(obj);
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }

    public Vehicle update(Integer id, Vehicle obj) {
        Vehicle newObj = findById(id);

        newObj.setManufacturer(obj.getManufacturer());
        newObj.setModel(obj.getModel());
        newObj.setColor(obj.getColor());
        newObj.setManufacturedAt(obj.getManufacturedAt());

        return repository.save(newObj);
    }
}
