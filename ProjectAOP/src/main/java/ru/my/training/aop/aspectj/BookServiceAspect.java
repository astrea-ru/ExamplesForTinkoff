package ru.my.training.aop.aspectj;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * Пример аспекта для трассировки
 */
@Aspect
public class BookServiceAspect {

    @Pointcut("execution(* ru.my.training.aop.SimpleBookService.*(..))")
    public void methodALLexecution() {
    }

    @Pointcut("call(* ru.my.training.aop.IBookService.*(..))")
    public void methodALLcall() {
    }

    @Pointcut("execution(* ru.my.training.aop.SimpleBookService.getAllInformationAboutBook())")
    public void methodGetAllInformation() {
    }

    @Before("methodALLexecution()")
    public void beforeExecution() {
        System.out.println("Start Execute Some Method from SimpleBookService");
    }

    @After("methodALLexecution()")
    public void afterExecution() {
        System.out.println("Stop Execute Some Method from SimpleBookService");
    }

    @Before("methodALLcall()")
    public void beforeCall() {
        System.out.println("Called method from IBookService");
    }

    @After("methodALLcall()")
    public void afterCall() {
        System.out.println("End call method from IBookService");
    }

}
