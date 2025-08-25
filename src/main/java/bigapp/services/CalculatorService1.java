package bigapp.services;

import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService1 {
  @NonNull
  public int add(int a, int b) {
    return a + b;
  }
}
