package services;

import entities.Product;

import java.util.List;

/**
 * Created by yslabko on 08/13/2017.
 */
public interface ProductService {
    Product getByModelAndSupplier(String model, String supplier);
    List<Product> getAll();
}
