package entities;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Class Car
 *
 * Created by yslabko on 08/08/2017.
 */
@Data
@NoArgsConstructor
public class Car {
    private long id;
    private String supplier;
    private String model;
    private Double price;

    public Car(String supplier, String model, Double price) {
        this.supplier = supplier;
        this.model = model;
        this.price = price;
    }
}
