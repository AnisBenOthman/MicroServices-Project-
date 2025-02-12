package tn.esprit.inventoryms.serviceImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.inventoryms.entites.Inventory;
import tn.esprit.inventoryms.entites.InventoryDTO;
import tn.esprit.inventoryms.entites.InventoryMapper;
import tn.esprit.inventoryms.exception.ResourceNotFoundException;
import tn.esprit.inventoryms.repository.InventoryRepository;
import tn.esprit.inventoryms.service.InventoryService;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class ServiceImpl implements InventoryService {
    final InventoryMapper inventoryMapper;
    final InventoryRepository inventoryRepository;

    @Override
    public Optional<Inventory> retrieveById(String integer) {
        return Optional.empty();
    }

    @Override
    public List<Inventory> retrieveAll() {
        return inventoryRepository.findAll();
    }

    @Override
    public Inventory add(Inventory object) {
        Inventory inventorySaved = inventoryRepository.save(object);

        return inventorySaved;
    }

    @Override
    public Inventory update(Inventory object, String integer) {
        Inventory result = inventoryRepository.findById(integer).orElseThrow(() -> new RuntimeException("Inventory not found with id: " + integer));
        result.setQuantity(object.getQuantity());
        inventoryRepository.save(result);

        return result;
    }

    @Override
    public void delete(String integer) {
        inventoryRepository.deleteById(integer);

    }


    @Override
    public InventoryDTO retrieveByCode(String code) {
        InventoryDTO inventory = inventoryRepository.findByCodeProduct(code);
        if (inventory != null) {
            return inventory;
        } else {
            throw new ResourceNotFoundException("Inventory not found for code: " + code);
        }
    }
}
