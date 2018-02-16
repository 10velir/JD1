package entities;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Class Item
 *
 * Created by yslabko on 07/01/2017.
 */
@Data
@NoArgsConstructor
public class Item {
    private long id;
    private long productId;
    private long orderId;
    private int quantity;
    private double discountPercent;

    public Item(long orderId, long productId, int quantity, double discountPercent) {
        this.orderId = orderId;
        this.productId = productId;
        this.quantity = quantity;
        this.discountPercent = discountPercent;
    }

    public Item(long orderId, long productId, int quantity) {
        this(orderId, productId, quantity, 0);
    }
}
