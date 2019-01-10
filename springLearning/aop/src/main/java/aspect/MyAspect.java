package aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
class MyAspect {

    @Before("execution(* *..UserServicesImpl.addUser())")
    public void before() {
        System.out.println("========前置通知========");
    }

    @After("execution(* *..UserServicesImpl.selectUser())")
    public void after() {
        System.out.println("========最终通知========:");
    }

    @AfterThrowing(value = "execution(* *..UserServicesImpl.selectUserById(..))" ,throwing = "e")
    public void afterThrowing(Exception e) {
        System.out.println("========异常通知========:" + e);
    }

    @AfterReturning(value = "execution(* *..UserServicesImpl.updateUser())",returning = "result")
    public void afterReturning(int result) {
        System.out.println("========后置通知========:" + result);
    }

    @Around(value = "execution(* *..UserServicesImpl.deleteUser())")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("========环绕通知:前========:");
        Object proceed = pjp.proceed();
        System.out.println("========环绕通知:后========:");

        return proceed;
    }
}
