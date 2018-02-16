package services;

import entities.Car;

import java.util.List;

/**
 * Created by yslabko on 08/13/2017.
 */
public interface ProductService {
    Car getByModelAndSupplier(String model, String supplier);
    List<Car> getAll();
}
