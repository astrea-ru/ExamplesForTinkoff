package ru.my.training.aop;

/**
 * Пример реализации сервиса IBookService, если бы мы не использовали аспекты
 */
public class BookService implements IBookService{
    private Book book = new Book();

    @Override
    public String getBookName() {
        try{
            System.out.println("Called method: getBookName");
            return book.getName();
        } catch (NullPointerException e){
            System.out.println("Book not found!!!");
            return null;
        }
    }

    @Override
    public String getBookAuthor() {
        try{
            System.out.println("Called method: getBookAuthor");
            return book.getAuthor();
        } catch (NullPointerException e){
            System.out.println("Book not found!!!");
            return null;
        }
    }

    @Override
    public Double getBookPrice() {
        try{
            System.out.println("Called method: getBookPrice");
            return book.getPrice();
        } catch (NullPointerException e){
            System.out.println("Book not found!!!");
            return null;
        }
    }

    @Override
    public String getAllInformationAboutBook() {
        try{
            System.out.println("Called method: getAllInformationAboutBook");
            return String.format("Author: %s; book: \"%s\", proca: %.2f", book.getAuthor(), book.getName(), book.getPrice());
        } catch (NullPointerException e){
            System.out.println("Book not found!!!");
            return null;
        }
    }
}
