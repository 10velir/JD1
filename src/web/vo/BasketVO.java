package web.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by yslabko on 08/16/2017.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BasketVO {
    private Map<Long, AtomicInteger> basket;
}
