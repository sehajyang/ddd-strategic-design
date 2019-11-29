package camp.nextstep.edu.kitchenpos.controller;

import camp.nextstep.edu.kitchenpos.SpringMockMvcTestSupport;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class MenuRestControllerTest extends SpringMockMvcTestSupport {

    @DisplayName("메뉴 목록을 조회한다")
    @Test
    void getMenuList() throws Exception {
        mockMvc.perform(get("/api/menus"))
                .andExpect(status().isOk())
        ;
    }
}