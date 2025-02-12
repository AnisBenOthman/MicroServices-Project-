package tn.esprit.spring.firstms.feignClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import tn.esprit.spring.firstms.dto.InventoryDTO;

@FeignClient(name = "inventoryService", url = "localhost:8083/inventoryMS")
public interface InventoryClient {
    @GetMapping("getinventorybycodepoduct/{code}")
    public InventoryDTO retrieveByCode(@PathVariable String code);


}
