package tn.esprit.inventoryms.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.inventoryms.entites.Inventory;
import tn.esprit.inventoryms.entites.InventoryDTO;
import tn.esprit.inventoryms.serviceImpl.ServiceImpl;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class ServiceController {
    @GetMapping("getinventory/{integer}")
    public Optional<Inventory> retrieveById(@PathVariable String integer) {
        return service.retrieveById(integer);
    }

    @GetMapping("getallinventory")
    public List<Inventory> retrieveAll() {
        return service.retrieveAll();
    }

    @PostMapping("addinventory")
    public Inventory add(@RequestBody Inventory object) {
        return service.add(object);
    }

    @PutMapping("updateinventory/{integer}")
    public Inventory update(@RequestBody Inventory object, @PathVariable String integer) {
        return service.update(object, integer);
    }

    @DeleteMapping("deleteinventory/{integer}")
    public void delete(@PathVariable String integer) {
        service.delete(integer);
    }

    @GetMapping("getinventorybycodepoduct/{code}")
    public InventoryDTO retrieveByCode(@PathVariable String code) {
        return service.retrieveByCode(code);
    }

    final ServiceImpl service;

}
