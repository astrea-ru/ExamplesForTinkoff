package ru.my.training.aop.aspectj;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 * Пример аспекта, который подеменяет результат выполнения метода
 */
@Aspect
public class FunnyAspect {

    @Pointcut("execution(* ru.my.training.aop.SimpleBookService.getAllInformationAboutBook())")
    public void methodGetAllInformation(){}

    @Around("methodGetAllInformation()")
    public Object justForFun(ProceedingJoinPoint thisJoinPoint) throws Throwable {
        thisJoinPoint.proceed();

        String result = "I LOVE THIS BOOK";

        return result;
    }

}
