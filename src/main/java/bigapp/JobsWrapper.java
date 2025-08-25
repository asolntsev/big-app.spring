package bigapp;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.MDC;
import org.springframework.aop.aspectj.MethodInvocationProceedingJoinPoint;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicLong;

@Aspect
@Component
public class JobsWrapper {
  private final AtomicLong counter = new AtomicLong();

  @Order(1)
  @Around("@annotation(org.springframework.scheduling.annotation.Scheduled)")
  public Object addMdcForJobs(ProceedingJoinPoint pjp) {
    if (pjp instanceof MethodInvocationProceedingJoinPoint joinPoint) {
      String jobName = joinPoint.getSignature().getName();
      MDC.put("jobId", jobName + "#" + counter.incrementAndGet());

      try {
        return proceed(joinPoint);
      }
      finally {
        MDC.clear();
      }
    }
    throw new RuntimeException("Scheduled annotation should be used at method level");
  }

  private Object proceed(MethodInvocationProceedingJoinPoint joinPoint) {
    try {
      return joinPoint.proceed();
    }
    catch (Throwable e) {
      throw new RuntimeException(e);
    }
  }
}
