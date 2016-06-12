package ru.project.calculator.operations;

/**
 * Интерфейс, описывающий операцию, выполняемую кальклятором
 */
public interface IOperation {

    /**
     * Метод, реализующий вычисление операции
     *
     * @param arg
     * @return
     */
    Double invoke(double[] arg) throws Exception;

    /**
     * Получение приоритета операции
     *
     * @return
     */
    PriorityOfOperation getPriority();

    /**
     * Получить тип операции
     *
     * @return
     */
    TypeOfOperation getType();
}
