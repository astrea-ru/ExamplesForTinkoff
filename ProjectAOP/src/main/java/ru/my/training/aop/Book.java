package ru.my.training.aop;

/**
 * DTO-класс, к информации которого предоставляет досутуп BookService
 */
public class Book {

    private String name="Effective Java";
    private String author="Joshua Bloch";
    private Double price = Double.valueOf("1000000.99");

    public Book(){}
    
    public Book(String author, String name, Double price){
        this.author = author;
        this.name = name;
        this.price = price;
    }
    
    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public Double getPrice() {
        return price;
    }
}
