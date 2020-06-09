package com.redlotus.user;

import com.redlotus.AbstractCapelWebTest;
import com.redlotus.RedlotusApplicationTest;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {RedlotusApplicationTest.class}, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Slf4j
@ActiveProfiles("rdltsJunit")
public class CapelUserControllerTestAbstract extends AbstractCapelWebTest {

    @Test
    public void testRegister() throws Exception {
        mockMvc.perform(put("/register")).andExpect(status().isOk());
    }
}
