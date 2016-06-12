package ru.my.training.aop;

/**
 * Интерфейс сервиса, на который "смотрит" аспект
 */
public interface IBookService {
    
    String getBookName();
    
    String getBookAuthor();
    
    Double getBookPrice();
    
    String getAllInformationAboutBook();
    
}
