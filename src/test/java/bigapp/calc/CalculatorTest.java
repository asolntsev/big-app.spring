package bigapp.calc;

import bigapp.services.CalculatorService0;
import org.junit.jupiter.api.RepeatedTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(Calculator.class)
@AutoConfigureMockMvc @EnableScheduling
class CalculatorTest {
  private static final Random random = new Random();

  @MockitoBean
  CalculatorService0 service;

  @Autowired
  private MockMvc mockMvc;

  @Autowired
  private Calculator controller;

  @RepeatedTest(10)
  void calculator() throws Exception {
    assertThat(controller).isNotNull();

    when(service.add(anyInt(), anyInt())).thenReturn(42);
    int a = random.nextInt();
    int b = random.nextInt();

    mockMvc.perform(get("/calc/add").param("a", String.valueOf(a)).param("b", String.valueOf(b)))
      // .andDo(print())
      .andExpect(status().isOk())
      .andExpect(content().string(equalTo("42")));

    verify(service).add(a, b);
  }
}
