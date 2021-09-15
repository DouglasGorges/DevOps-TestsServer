package com.fullstack.vehicles.resources;

import com.fullstack.vehicles.domain.Vehicle;
import com.fullstack.vehicles.services.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/vehicles")
public class VehicleResource {

    @Autowired
    VehicleService service;

    @GetMapping(value = "/list/{id}")
    public ResponseEntity<Vehicle> findById(@PathVariable Integer id) {
        Vehicle obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping(value = "/list/all")
    public ResponseEntity<List<Vehicle>> listAll() {
        List<Vehicle> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @PostMapping
    public ResponseEntity<Vehicle> create(@RequestBody Vehicle obj) {
        obj = service.create(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{/id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Vehicle> update(@PathVariable Integer id, @RequestBody Vehicle obj) {
        Vehicle newObj = service.update(id, obj);

        return ResponseEntity.ok().body(newObj);
    }

}
