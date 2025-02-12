package tn.esprit.spring.firstms.controller;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.firstms.Entities.Product;
import tn.esprit.spring.firstms.Entities.Status;
import tn.esprit.spring.firstms.ServiceImpl.ProductImpl;
import tn.esprit.spring.firstms.dto.ProductDTO;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequiredArgsConstructor  // Lombok will generate the constructor for dependency injection
public class ServiceController {
@GetMapping("getproductdetails/{code}/{status}")
    public ProductDTO getProductDetails(@PathVariable String code, @PathVariable Status status) {
        return productImpl.getProductDetails(code, status);
    }

    private final ProductImpl productImpl; // Spring will inject this dependency automatically

    @GetMapping("getproductbyid/{integer}")
    public Optional<Product> retrieveById(@PathVariable Integer integer) {
        return productImpl.retrieveById(integer);
    }

    @GetMapping("getallproduct")
    public List<Product> retrieveAll() {
        return productImpl.retrieveAll();
    }

    @PostMapping("addproduct")
    public Product add(@RequestBody Product object) {
        return productImpl.add(object);
    }

    @PutMapping("updateproduct/{integer}")
    public Product update(@RequestBody Product object, @PathVariable Integer integer) {
        return productImpl.update(object, integer);
    }

    @DeleteMapping("deleteproduct/{integer}")
    public void delete(@PathVariable Integer integer) {
        productImpl.delete(integer);
    }
}
