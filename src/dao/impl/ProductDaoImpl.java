package dao.impl;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dao.ProductDao;
import entities.Car;

/**
 * Class ProductDaoImpl
 *
 * Created by yslabko on 08/08/2017.
 */
public class ProductDaoImpl extends AbstractDao implements ProductDao {
    private static volatile ProductDao INSTANCE = null;

    private static final String saveProductQuery = "INSERT INTO PRODUCT (SUPPLIER, MODEL, PRICE) VALUES (?, ?, ?)";
    private static final String updateProductQuery = "UPDATE PRODUCT SET SUPPLIER=?, MODEL=?, PRICE=? WHERE ID=?";
    private static final String getProductQuery = "SELECT * FROM PRODUCT WHERE ID=?";
    private static final String getAllProductQuery = "SELECT * FROM PRODUCT";
    private static final String getByModelAndSupplierQuery = "SELECT * FROM PRODUCT WHERE MODEL=? AND SUPPLIER=?";
    private static final String deleteProductQuery = "DELETE FROM PRODUCT WHERE ID=?";

    private PreparedStatement psSave;
    private PreparedStatement psUpdate;
    private PreparedStatement psGet;
    private PreparedStatement psGetByModelAndSupplier;
    private PreparedStatement psGetAll;
    private PreparedStatement psDelete;

    private ProductDaoImpl() {
    }

    @Override
    public Car save(Car car) throws SQLException {
        psSave = prepareStatement(saveProductQuery, Statement.RETURN_GENERATED_KEYS);
        psSave.setString(1, car.getSupplier());
        psSave.setString(2, car.getModel());
        psSave.setDouble(3, car.getPrice());
        psSave.executeUpdate();
        ResultSet rs = psSave.getGeneratedKeys();
        if (rs.next()) {
            car.setId(rs.getLong(1));
        }
        close(rs);
        return car;
    }

    @Override
    public Car get(Serializable id) throws SQLException {
        psGet = prepareStatement(getProductQuery);
        psGet.setLong(1, (long)id);
        psGet.executeQuery();
        ResultSet rs = psGet.getResultSet();
        if (rs.next()) {
            return populateProduct(rs);
        }
        close(rs);

        return null;
    }

    @Override
    public void update(Car car) throws SQLException {
        psUpdate = prepareStatement(updateProductQuery);
        psUpdate.setLong(4, car.getId());
        psUpdate.setString(1, car.getSupplier());
        psUpdate.setString(2, car.getModel());
        psUpdate.setDouble(3, car.getPrice());
        psUpdate.executeUpdate();
    }

    @Override
    public int delete(Serializable id) throws SQLException {
        psDelete = prepareStatement(deleteProductQuery);
        psDelete.setLong(1, (long)id);
        return psDelete.executeUpdate();
    }

    @Override
    public Car getByModelAndSupplier(String model, String supplier) throws SQLException {
        psGetByModelAndSupplier = prepareStatement(getByModelAndSupplierQuery);
        psGetByModelAndSupplier.setString(1, model);
        psGetByModelAndSupplier.setString(2, supplier);
        psGetByModelAndSupplier.execute();
        ResultSet rs = psGetByModelAndSupplier.getResultSet();
        while (rs.next()) {
            Car car = new Car();
            car.setId(rs.getLong(1));
            car.setSupplier(rs.getString(2));
            car.setModel(rs.getString(3));
            car.setPrice(rs.getDouble(4));
        }
        close(rs);

        return null;
    }

    @Override
    public List<Car> getAll() throws SQLException {
        psGetAll = prepareStatement(getAllProductQuery);
        psGetAll.execute();
        ResultSet rs = psGetAll.getResultSet();
        List<Car> list = new ArrayList<>();
        while (rs.next()) {
            list.add(populateProduct(rs));
        }
        close(rs);
        return list;
    }

    private Car populateProduct(ResultSet rs) throws SQLException {
        Car car = new Car();
        car.setId(rs.getLong(1));
        car.setSupplier(rs.getString(2));
        car.setModel(rs.getString(3));
        car.setPrice(rs.getDouble(4));
        return car;
    }

    public static ProductDao getInstance() {
        ProductDao productDao = INSTANCE;
        if (productDao == null) {
            synchronized (ProductDaoImpl.class) {
                productDao = INSTANCE;
                if (productDao == null) {
                    INSTANCE = productDao = new ProductDaoImpl();
                }
            }
        }

        return productDao;
    }
}
