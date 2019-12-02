package camp.nextstep.edu.kitchenpos;


import camp.nextstep.edu.kitchenpos.model.Order;
import camp.nextstep.edu.kitchenpos.model.OrderLineItem;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

public class MockUtils {
    private static final LocalDateTime mockTime = LocalDateTime.of(2019, 12, 1, 1, 0, 0);

    public static Order mockOrder(long id, long tableId, String orderStatus) {
        Order order = new Order();
        order.setId(id);
        order.setOrderTableId(tableId);
        order.setOrderStatus(orderStatus);
        order.setOrderedTime(mockTime);
        return order;
    }

    public static OrderLineItem mockOrderLineItem(long orderId, int quantity) {
        OrderLineItem orderLineItem = new OrderLineItem();
        orderLineItem.setOrderId(orderId);
        orderLineItem.setMenuId(1L);
        orderLineItem.setQuantity(quantity);
        orderLineItem.setSeq(0L);
        return orderLineItem;
    }

    public static List<OrderLineItem> mockOrderlineItemList(){
        OrderLineItem orderLineItem = mockOrderLineItem(1L, 1);
        return Collections.singletonList(orderLineItem);
    }
}
