package tn.esprit.inventoryms.repository;


import tn.esprit.inventoryms.entites.Inventory;
import tn.esprit.inventoryms.entites.InventoryDTO;
import tn.esprit.inventoryms.entites.InventoryMapper;

import java.util.Optional;

public interface InventoryRepository extends BasedRepository<Inventory,String> {
    InventoryDTO findByCodeProduct(String code);
}
