package ru.my.training.aop.aspectj;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 * Пример аспекта, реализующего ведение журналирования
 */

@Aspect
public class LoggerAspect {
    // Описываем точки перехвата
    @Pointcut("execution(* ru.my.training.aop.SimpleBookService.*(..))")
    public void methodALLexecution() { }

    @Pointcut("execution(* ru.my.training.aop.SimpleBookService.setBook(..))")
    public void methodSetBook() { }

    //СОвет типа Around.
    @Around("methodALLexecution() && !methodSetBook()")
    public Object someAspect(ProceedingJoinPoint thisJoinPoint) throws Throwable {
        String methodName = thisJoinPoint.getSignature().getName();
        Object[] methodArgs = thisJoinPoint.getArgs();

        System.out.println("Call method " + methodName + " with args " + methodArgs);

        Object result = thisJoinPoint.proceed();

        System.out.println("Method " + methodName + " returns " + result);

        return result;
    }
}
