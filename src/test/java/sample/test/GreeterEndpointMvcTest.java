package sample.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(value = GreeterEndpoint.class)
public class GreeterEndpointMvcTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    GreeterClient greeterClient;

    @Test
    public void testSecondEndpoint() throws Exception {

        given(greeterClient.getCustomerToGreet())
                .willReturn(Customer.builder()
                        .firstName("John")
                        .lastName("Doe")
                        .build());

        mvc.perform(get("/second")).andExpect(status().isOk());
    }
}