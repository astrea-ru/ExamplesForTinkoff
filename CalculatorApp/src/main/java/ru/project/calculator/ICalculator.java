package ru.project.calculator;

/**
 * Интерфейс калькулятора
 */
public interface ICalculator {
    /**
     * Метод для выполнения вычисления выражения
     *
     * @param expression  вычисляемое выражение
     * @return
     */
    double calculate(String expression) throws Exception;
}
