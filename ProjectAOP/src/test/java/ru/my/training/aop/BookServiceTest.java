package ru.my.training.aop;

import org.junit.Test;

public class BookServiceTest {

    @Test
    public void test_1(){
        System.out.println("----------<<<---->>>----------");
        IBookService service = new SimpleBookService();

        System.out.println(service.getBookName());
        System.out.println("----------<<<---->>>----------");
    }

    @Test
    public void test_2(){
        System.out.println("----------<<<---->>>----------");
        IBookService service = new SimpleBookService();

        System.out.println(service.getAllInformationAboutBook());
        System.out.println("----------<<<---->>>----------");
    }

    @Test(expected = NullPointerException.class)
    public void throw_test(){
        System.out.println("----------<<<---->>>----------");
        SimpleBookService service = new SimpleBookService();
        service.setBook(null);

        System.out.println(service.getBookAuthor());
        System.out.println("----------<<<---->>>----------");
    }
}
