# AOP

## 1. setup

```xml
<dependency>
    <groupId>org.aspectj</groupId>
    <artifactId>aspectjweaver</artifactId>
    <version>1.8.13</version>
</dependency>
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-aspects</artifactId>
    <version>5.0.4.RELEASE</version>
</dependency>
```

## 2. create spring-aop.xml in resources folder

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xmlns:aop="http://www.springframework.org/schema/aop"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
	   http://www.springframework.org/schema/beans/spring-beans.xsd
	   http://www.springframework.org/schema/context
	   http://www.springframework.org/schema/context/spring-context.xsd
	   http://www.springframework.org/schema/aop
	   http://www.springframework.org/schema/aop/spring-aop.xsd">

    <context:component-scan base-package=""/>
    <!--配置AspectJ自动代理-->
    <aop:aspectj-autoproxy/>

</beans>
```

Note:

-   Please be sure this `spring-aop.xml` import to your `applicationContext.xml`.

## 3. create aspect

```java
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
```

## 4. execution expression

```
execution(public * *(..)) 
指定切入点为：任意公共方法。

execution(* set*(..)) 
指定切入点为：任何一个以“set”开始的方法。

execution(* com.xyz.service.*.*(..)) 
指定切入点为：定义在 service 包里的任意类的任意方法。

execution(* com.xyz.service..*.*(..))
指定切入点为：定义在 service 包或者子包里的任意类的任意方法。“..”出现在类名中时，后面必须跟“*”，表示包、子包下的所有类。

execution(* *.service.*.*(..))
指定只有一级包下的 serivce 子包下所有类（接口）中所有方法为切入点 

execution(* *..service.*.*(..))
指定所有包下的 serivce 子包下所有类（接口）中所有方法为切入点 

execution(* *.ISomeService.*(..))
指定只有一级包下的 ISomeSerivce 接口中所有方法为切入点 

execution(* *..ISomeService.*(..))
指定所有包下的 ISomeSerivce 接口中所有方法为切入点 

execution(* com.xyz.service.IAccountService.*(..)) 
指定切入点为：  IAccountService  接口中的任意方法。 

execution(* com.xyz.service.IAccountService+.*(..)) 
指定切入点为：  IAccountService  若为接口，则为接口中的任意方法及其所有实现类中的任意方法；若为类，则为该类及其子类中的任意方法。 

execution(* joke(String,int)))
指定切入点为：所有的 joke(String,int)方法，且 joke()方法的第一个参数是 String，第二个参    数是 int。如果方法中的参数类型是 java.lang 包下的类，可以直接使用类名，否则必须使用全限定类名，如 joke( java.util.List, int)。 

execution(* joke(String,*))) 
指定切入点为：所有的 joke()方法，该方法第一个参数为 String，第二个参数可以是任意类型，如 joke(String s1,String s2)和 joke(String s1,double d2)都是，但 joke(String s1,double d2,String s3)不是。

execution(* joke(String,..)))   
指定切入点为：所有的 joke()方法，该方法第  一个参数为 String，后面可以有任意个参数且参数类型不限，如 joke(String s1)、joke(String s1,String s2)和 joke(Strings1,double d2,String s3)都是。

execution(* joke(Object))
指定切入点为：所有的 joke()方法，方法拥有一个参数，且参数是 Object 类型。joke(Object ob)是，但，joke(String s)与 joke(User u)均不是。

execution(* joke(Object+))) 
指定切入点为：所有的 joke()方法，方法拥有一个参数，且参数是 Object 类型或该类的子类。不仅 joke(Object ob)是，joke(String s)和 joke(User u)也是。
```