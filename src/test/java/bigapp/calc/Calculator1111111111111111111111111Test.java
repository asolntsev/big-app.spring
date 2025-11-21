package bigapp.calc;

import org.junit.jupiter.api.RepeatedTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Random;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(Calculator1111111111111111111111111.class)
@AutoConfigureMockMvc @EnableScheduling
class Calculator1111111111111111111111111Test {
  private static final Random random = new Random();

  @Autowired
  private MockMvc mockMvc;

  @RepeatedTest(1000)
  void calculator() throws Exception {
    int a = random.nextInt();
    int b = random.nextInt();

    mockMvc.perform(get("/calc/add1111111111111111111111111").param("a", String.valueOf(a)).param("b", String.valueOf(b)))
      .andExpect(status().isOk())
      .andExpect(content().string(equalTo(String.valueOf(a + b))));
  }
}
