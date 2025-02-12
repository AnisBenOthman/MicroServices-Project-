package tn.esprit.spring.firstms.feignClient;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import tn.esprit.spring.firstms.dto.InventoryDTO;

@FeignClient(name = "inventoryService", url = "localhost:8083/inventoryMS")
public interface InventoryClient {
    @GetMapping("getinventorybycodepoduct/{code}")
    @CircuitBreaker(name = "inventory-service", fallbackMethod = "fallbackInventory")
    public InventoryDTO retrieveByCode(@PathVariable String code);

    default String fallbackInventory(String code, Throwable throwable){
        return "Inventory data is currently unavailable for product" + code;
    }


}
