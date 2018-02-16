package services.impl;

import dao.ProductDao;
import dao.impl.ProductDaoImpl;
import entities.Car;
import services.ProductService;
import services.ServiceException;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by yslabko on 08/13/2017.
 */
public class ProductServiceImpl extends AbstractService implements ProductService {
    private static volatile ProductService INSTANCE = null;

    ProductDao productDao = ProductDaoImpl.getInstance();

    @Override
    public Car getByModelAndSupplier(String model, String supplier) {
        try {
            return productDao.getByModelAndSupplier(model, supplier);
        } catch (SQLException e) {
            throw new ServiceException("Error getting by Supplier:" + supplier + " and Model:" + model);
        }
    }

    @Override
    public List<Car> getAll() {
        try {
            startTransaction();
            List<Car> list = productDao.getAll();
            commit();
            return list;
        } catch (SQLException e) {
            rollback();
            throw new ServiceException("Error getting Products");
        }
    }

    public static ProductService getInstance() {
        ProductService productService = INSTANCE;
        if (productService == null) {
            synchronized (ProductServiceImpl.class) {
                productService = INSTANCE;
                if (productService == null) {
                    INSTANCE = productService = new ProductServiceImpl();
                }
            }
        }

        return productService;
    }
}
