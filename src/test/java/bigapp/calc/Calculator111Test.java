package bigapp.calc;

import bigapp.services.CalculatorService3;
import org.junit.jupiter.api.RepeatedTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Random;

import static org.hamcrest.Matchers.equalTo;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(Calculator111.class)
@AutoConfigureMockMvc @EnableScheduling
class Calculator111Test {
  private static final Random random = new Random();

  @MockitoBean
  CalculatorService3 service;

  @Autowired
  private MockMvc mockMvc;

  @RepeatedTest(1000)
  void calculator() throws Exception {
    int a = random.nextInt();
    int b = random.nextInt();
    when(service.add(anyInt(), anyInt())).thenCallRealMethod();

    mockMvc.perform(get("/calc/add111").param("a", String.valueOf(a)).param("b", String.valueOf(b)))
      .andExpect(status().isOk())
      .andExpect(content().string(equalTo(String.valueOf(a + b))));

    verify(service).add(a, b);
  }
}
