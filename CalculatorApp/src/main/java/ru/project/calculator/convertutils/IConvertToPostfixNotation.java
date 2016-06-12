package ru.project.calculator.convertutils;

import java.util.List;

/**
 * Интерфейс, описывающий методв преобразования поступившего выражения в удобный вид для вычисления
 */
public interface IConvertToPostfixNotation {

    List<String> convert(String input) throws IllegalArgumentException;

}
