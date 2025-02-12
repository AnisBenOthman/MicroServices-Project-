package tn.esprit.spring.firstms.ServiceImpl;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.spring.firstms.Entities.Product;
import tn.esprit.spring.firstms.Entities.ProductMapper;
import tn.esprit.spring.firstms.Entities.Status;
import tn.esprit.spring.firstms.Repositories.ProductRepository;
import tn.esprit.spring.firstms.Services.IProductService;
import tn.esprit.spring.firstms.dto.InventoryDTO;
import tn.esprit.spring.firstms.dto.ProductDTO;
import tn.esprit.spring.firstms.feignClient.InventoryClient;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ProductImpl implements IProductService {
    final ProductRepository productRepository;
    final ProductMapper productMapper; //for DTO conversion
    final InventoryClient inventoryClient;


    @Override
    public Optional<Product> retrieveById(Integer integer) {
        try {
            return productRepository.findById(integer);

        } catch (Exception e) {
            // Log the error and return an empty Optional
            System.err.println("Error retrieving product by ID: " + e.getMessage());
            return Optional.empty();
        }
    }


    @Override
    public List<Product> retrieveAll() {
        return productRepository.findAll();
    }





    @Override
    public Product add(Product object) {
        Product product= productRepository.save(object);
        return product;
    }

    @Override
    public Product update(Product object, Integer integer) {
        Product product = productRepository.findById(integer).orElseThrow(() -> new RuntimeException("Product not found with id: " + integer));
        product.setLabel(object.getLabel());
        product.setPrice(object.getPrice());
        productRepository.save(product);

        return product;
    }


    @Override
    public void delete(Integer integer) {
        productRepository.deleteById(integer);
    }




    @Override
    public ProductDTO getProductDetails(String code, Status status) {
        Product product = productRepository.findByCodeAndStatus(code, status).orElseThrow(() -> new RuntimeException("Product not found with code: " + code));
        InventoryDTO inventoryDTO = inventoryClient.retrieveByCode(code);
        ProductDTO productDTO = new ProductDTO(product.getId(), product.getLabel(), product.getPrice(), inventoryDTO.quantity());
        return productDTO;
    }
}
