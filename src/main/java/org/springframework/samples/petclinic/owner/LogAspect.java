package org.springframework.samples.petclinic.owner;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Component
@Aspect
public class LogAspect {
	Logger logger = LoggerFactory.getLogger(LogAspect.class);
	/*
		설명: logger(slf4j) 는 console창에 Log 메세지를 띄어주는 클래스
			 @Around는 AspectJ 라이브러리의 어노테이션이며, Around 어노테이션을 사용하는 메소드는 joinPoint라는 파라미터를
			 받을 수 있게 된다.
			 joinPoint란 @Around의 인자값으로 넣은 OwnerController에서 @LogExecutionTime 이 설정된 메소드를 뜻하며,
			 해당 메소드는 joinPoint라는 인터페이스로 들어오게 되고, proceed()메소드를 통해 그 메소드를 실행하게 된다.
			 [즉 ProxyPettern과 동일한 동작을 한다.]
			 r

	 */
	@Around("@annotation(LogExecutionTime)")
	public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable{
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();

		Object proceed = joinPoint.proceed();
		stopWatch.stop();
		logger.info(stopWatch.prettyPrint());
		return proceed;
	}
}
