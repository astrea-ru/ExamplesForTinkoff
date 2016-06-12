package ru.my.training.aop.aspectj;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;

/**
 * Пример аспекта для обработки возникших исключений
 */
@Aspect
public class ThrowAspect {
    @AfterThrowing(pointcut = "execution(* ru.my.training.aop.IBookService.*(..))", throwing = "e")
    public void myAfterThrowing(JoinPoint joinPoint, Throwable e){
        System.out.println("Sorry, book not found!!!");
    }
}
