package camp.nextstep.edu.kitchenpos.bo;

import camp.nextstep.edu.kitchenpos.dao.OrderDao;
import camp.nextstep.edu.kitchenpos.dao.OrderLineItemDao;
import camp.nextstep.edu.kitchenpos.dao.OrderTableDao;
import camp.nextstep.edu.kitchenpos.dao.TableGroupDao;
import camp.nextstep.edu.kitchenpos.model.Order;
import camp.nextstep.edu.kitchenpos.model.OrderLineItem;
import camp.nextstep.edu.kitchenpos.model.OrderStatus;
import camp.nextstep.edu.kitchenpos.model.OrderTable;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.context.annotation.Description;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static camp.nextstep.edu.kitchenpos.MockUtils.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OrderBoTest {

    @Mock
    private OrderDao orderDao;

    @Mock
    private OrderLineItemDao orderLineItemDao;

    @Mock
    private OrderTableDao orderTableDao;

    @Mock
    private TableGroupDao tableGroupDao;

    @InjectMocks
    private OrderBo orderBo;

    @Test
    @Description("주문 목록을 조회할 수 있다")
    void getOrderList() {
        //given
        List<Order> orderList = Arrays.asList(
                mockOrder(1L, 1L, OrderStatus.COOKING.name()),
                mockOrder(2L, 2L, OrderStatus.COMPLETION.name())
        );

        //when
        when(orderDao.findAll())
                .thenReturn(orderList);
        when(orderLineItemDao.findAllByOrderId(anyLong()))
                .thenReturn(mockOrderlineItemList());
        List<Order> getOrderList = orderBo.list();

        // then
        assertThat(getOrderList).hasSize(2);
    }

    @Test
    @Description("주문 등록시 주문 아이템의 정보가 없을경우 IllegalArgumentException이 발생해야 한다")
    void orderItemsCountUnderZero() {
        //given
        Order order = mockOrder(1L, 1L, OrderStatus.COOKING.name());
        order.setOrderLineItems(null);

        //then
        assertThatThrownBy(() -> orderBo.create(order))
                .isInstanceOf(IllegalArgumentException.class);

    }

    @Test
    @Description("주문 등록시 '주문 테이블' 식별자가 없을경우 IllegalArgumentException이 발생해야 한다")
    void notExistOrderTableId() {
        //given
        Order order = mockOrder(1L, 1L,OrderStatus.COOKING.name());
        order.setOrderTableId(null);
        order.setOrderLineItems(mockOrderlineItemList());

        //then
        assertThatThrownBy(() -> orderBo.create(order))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @Description("주문 등록시 '주문 테이블 그룹'식별자가 없을경우 IllegalArgumentException이 발생해야 한다")
    void notExistOrderTableGroupId() {
        //given
        Order order = mockOrder(1L, 1L,OrderStatus.COOKING.name());
        order.setOrderLineItems(mockOrderlineItemList());
        OrderTable orderTable = new OrderTable();
        orderTable.setTableGroupId(null);

        //when
        when(orderTableDao.findById(anyLong())).thenReturn(Optional.of(orderTable));
        when(orderTable.getTableGroupId()).thenReturn(1L);

        //then
        assertThatThrownBy(() -> orderBo.create(order))
                .isInstanceOf(IllegalArgumentException.class);

    }

    @Test
    @Description("주문 등록시 주문 상태는 COOKING 이어야 한다")
    void registerOrderStateIsCooking() {
        //given
        //when
        //then

    }

    @Test
    @Description("주문 등록시 주문 시각은 등록 요청한 시간이어야 한다 ")
    void registerOrderTimeIsNowTime() {
        //given
        //when
        //then

    }


    // FIXME : 모호한 description
    @Test
    @Description("주문 상태가 COMTLATION인 경우는 주문상태를 변경할 수 없어야 한다")
    void modifyOrderState() {
        //given
        //when
        //then

    }


}