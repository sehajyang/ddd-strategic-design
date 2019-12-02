package camp.nextstep.edu.kitchenpos.bo;

import camp.nextstep.edu.kitchenpos.dao.OrderDao;
import camp.nextstep.edu.kitchenpos.model.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.context.annotation.Description;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OrderBoTest {

    @Mock
    private OrderDao orderDao;

    @InjectMocks
    private OrderBo orderBo;

    @Test
    @Description("주문 목록을 조회할 수 있다")
    void getOrderList() {
        //given
        List<Order> orderList = new ArrayList<>();
        //when
        when(orderDao.findAll())
                .thenReturn(orderList);
        List<Order> getOrderList = orderBo.list();
        // then
        assertThat(getOrderList).hasSize(0);
    }

    @Test
    @Description("주문 등록시 주문 수량이 0보다 작을 경우 IllegalArgumentException이 발생해야 한다")
    void orderItemsCountUnderZero() {
        //given
        //when
        //then

    }

    @Test
    @Description("주문 등록시 주문 테이블 식별자가 없을경우 IllegalArgumentException이 발생해야 한다")
    void notExistOrderTableId() {
        //given
        //when
        //then

    }

    @Test
    @Description("주문 등록시 주문 테이블 그룹 식별자가 없을경우 IllegalArgumentException이 발생해야 한다")
    void notExistOrderTableGroupId() {
        //given
        //when
        //then

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