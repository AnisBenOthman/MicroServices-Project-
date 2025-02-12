package tn.esprit.inventoryms.entites;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "inventories")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Inventory extends BaseEntity{
    String codeProduct;
    int quantity;
    String location;
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
