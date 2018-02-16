package services;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import entities.Item;

/**
 * Class ItemService
 *
 * Created by yslabko on 07/02/2017.
 */
public interface ItemService {

    Item save(Item item);

    Item get(Serializable id);

    void update(Item item);

    int delete(Serializable id);

    List<Item> getByOrderId(long productId);
}
