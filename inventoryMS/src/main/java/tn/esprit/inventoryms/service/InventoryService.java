package tn.esprit.inventoryms.service;

import tn.esprit.inventoryms.entites.Inventory;
import tn.esprit.inventoryms.entites.InventoryDTO;

import java.util.Optional;

public interface InventoryService extends BasedService<Inventory, String> {
    InventoryDTO  retrieveByCode(String code);
}
