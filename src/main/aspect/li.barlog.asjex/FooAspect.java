package li.barlog.asjex;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

@Aspect
public class FooAspect {
	@Pointcut("execution(* li.barlog.asjex.Foo.foo(..))")
	public void methodFooFromTypeFoo() {}

	@Before("methodFooFromTypeFoo()")
	public void before(JoinPoint joinPoint) {
		System.out.println("before " + joinPoint.toLongString());
	}

	@Around("methodFooFromTypeFoo()")
	public Object around(ProceedingJoinPoint proceedingJoinPoint) {
		System.out.println("Around before " + proceedingJoinPoint.toLongString());
		Object returnObj = proceedingJoinPoint.proceed();

		System.out.println("Around after " + proceedingJoinPoint.toLongString());
		return returnObj;
	}

	/**
	 * Pointcut with "this" instance and parameters
	 * @param o
	 * @param i
	 */

	@Pointcut("execution(* li.barlog.asjex.Foo.setI(..)) && this(o) && args(i)")
	public void methodSetIFromTypeFoo(Foo o, int i) {}

	@Before("methodSetIFromTypeFoo(o,i)")
	public void before(JoinPoint joinPoint, Foo o, int i) {
		System.out.println("before " + joinPoint.toLongString()+ "i=" +i);
	}

	@Around("methodSetIFromTypeFoo(o,i)")
	public Object around(ProceedingJoinPoint proceedingJoinPoint, Foo o, int i) {
		System.out.println("Around before " + proceedingJoinPoint.toLongString()+ " foo.getI()="+o.getI()+ " i=" +i);
		Object returnObj = proceedingJoinPoint.proceed();
		System.out.println("Around after " + proceedingJoinPoint.toLongString()+ " foo.getI()="+o.getI()+ " i=" +i);
		return returnObj;
	}


}
