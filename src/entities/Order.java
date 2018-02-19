package entities;

import java.util.ArrayList;
import java.util.List;

import lombok.*;

/**
 * Class Order
 *
 * Created by yslabko on 08/08/2017.
 */
@Data
@NoArgsConstructor

public class Order {
    private long id;
    private long userId;
    private List<Item> items = new ArrayList<>();
    private double total;
    private boolean paid;

    public Order(long id, long userId, List<Item> items, double total, boolean paid) {
        this.id = id;
        this.userId = userId;
        this.items = items;
        this.total = total;
        this.paid = paid;
    }
}
