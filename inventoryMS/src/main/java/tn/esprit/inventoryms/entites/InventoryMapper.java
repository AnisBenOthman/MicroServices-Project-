package tn.esprit.inventoryms.entites;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface InventoryMapper {
    InventoryMapper INSTANCE = Mappers.getMapper(InventoryMapper.class);
    InventoryDTO inventoryToInventoryDTO(Inventory inventory);
    Inventory inventoryDTOToInventory(InventoryDTO inventoryDTO);

}
