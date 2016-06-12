package ru.my.training.aop;

/**
 * Простая реализация IBookService
 */
public class SimpleBookService implements IBookService{

    private Book book = new Book();

    @Override
    public String getBookName() {
        return book.getName();
    }

    @Override
    public String getBookAuthor() {
        return book.getAuthor();
    }

    @Override
    public Double getBookPrice() {
        return book.getPrice();
    }

    @Override
    public String getAllInformationAboutBook() {
        return String.format("Author: %s; book: \"%s\", proca: %.2f", book.getAuthor(), book.getName(), book.getPrice());
    }

    public void setBook(Book book){
        this.book = book;
    }

}
