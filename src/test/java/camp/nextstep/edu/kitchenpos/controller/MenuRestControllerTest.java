package camp.nextstep.edu.kitchenpos.controller;

import camp.nextstep.edu.kitchenpos.SpringMockMvcTestSupport;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class MenuRestControllerTest extends SpringMockMvcTestSupport {

    @Test
    void getMenuList() throws Exception {
        mockMvc.perform(get("/api/menus"))
                .andDo(print())
                .andExpect(status().isOk())
        ;
    }
}