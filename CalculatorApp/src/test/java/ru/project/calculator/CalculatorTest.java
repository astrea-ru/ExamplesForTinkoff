package ru.project.calculator;

import org.junit.Assert;
import org.junit.Test;
import ru.project.calculator.convertutils.IConvertToPostfixNotation;

import java.util.ArrayList;
import java.util.Arrays;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CalculatorTest {
    private static final double DELTA = 1e-14;

    @Test
    public void calculate_returns_correct_result()throws Exception{
        String expression = "2+3*(4-2)+25*(6-1)+0.25";
        IConvertToPostfixNotation converter = mock(IConvertToPostfixNotation.class);
        when(converter.convert(expression)).thenReturn(new ArrayList<String>(Arrays.asList("2", "3", "4", "2", "-", "*", "+", "25", "6", "1", "-", "*", "+", "0.25", "+")));
        double correctResult = 133.25;
        
        ICalculator calculator = new Calculator(converter);
        double result = calculator.calculate(expression);

        Assert.assertEquals(correctResult, result, DELTA);
    }

    @Test(expected = IllegalArgumentException.class)
    public void calculste_throws_IllegalArgumentException_if_operation_not_found() throws Exception{
        String expression = "2+3(4-2)";
        IConvertToPostfixNotation converter = mock(IConvertToPostfixNotation.class);
        when(converter.convert(expression)).thenReturn(new ArrayList<String>(Arrays.asList("2", "3", "4","2","-","+")));

        ICalculator calculator = new Calculator(converter);
        calculator.calculate(expression);
    }

    @Test(expected = IllegalArgumentException.class)
    public void calculste_throws_IllegalArgumentException_if_was_fins_unknow_simbol() throws Exception{
        String expression = "2+3*a";
        IConvertToPostfixNotation converter = mock(IConvertToPostfixNotation.class);
        when(converter.convert(expression)).thenReturn(new ArrayList<String>(Arrays.asList("2", "3", "a","*","+")));

        ICalculator calculator = new Calculator(converter);
        calculator.calculate(expression);
    }

    @Test
    public void calculate_returns_expression_if_expression_have_not_operation() throws Exception{
        String expression = "23";
        IConvertToPostfixNotation converter = mock(IConvertToPostfixNotation.class);
        when(converter.convert(expression)).thenReturn(new ArrayList<String>(Arrays.asList("23")));
        double correctResult = 23.00;

        ICalculator calculator = new Calculator(converter);
        double result = calculator.calculate(expression);

        Assert.assertEquals(correctResult, result, DELTA);
    }

}
