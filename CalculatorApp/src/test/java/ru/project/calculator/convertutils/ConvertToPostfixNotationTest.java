package ru.project.calculator.convertutils;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConvertToPostfixNotationTest {

    @Test
    public void convert_returns_correct_conversion_for_expression_with_brackets(){
        String expression = "3*(4-2)";
        List<String> correct_result=new ArrayList<String>(Arrays.asList("3", "4", "2", "-", "*"));

        IConvertToPostfixNotation converter = new ConvertToPostfixNotation();
        List<String> result = converter.convert(expression);

        Assert.assertEquals(correct_result, result);
    }

    @Test
    public void convert_returns_correct_conversion(){
        String expression = "2+3*(4-2)+25*(6-1)+0.25";
        List<String> correct_result=new ArrayList<String>(Arrays.asList("2", "3", "4", "2", "-", "*", "+", "25", "6", "1", "-", "*", "+", "0.25", "+"));

        IConvertToPostfixNotation converter = new ConvertToPostfixNotation();
        List<String> result = converter.convert(expression);

        Assert.assertEquals(correct_result, result);
    }

    @Test
    public void convert_returns_correct_conversion_for_expression_with_letters(){
        String expression = "ab*(c-2)";
        List<String> correct_result=new ArrayList<String>(Arrays.asList("ab", "c", "2", "-", "*"));

        IConvertToPostfixNotation converter = new ConvertToPostfixNotation();
        List<String> result = converter.convert(expression);

        Assert.assertEquals(correct_result, result);
    }

    @Test
    public void convert_returns_correct_conversion_for_expression_with_delimiters(){
        String expression = "0.25+2,56";
        List<String> correct_result=new ArrayList<String>(Arrays.asList("0.25", "2,56", "+"));

        IConvertToPostfixNotation converter = new ConvertToPostfixNotation();
        List<String> result = converter.convert(expression);

        Assert.assertEquals(correct_result, result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void convert_throws_exception_if_closing_bracket_is_missing(){
        String expression = "(2+3*(6-2)";

        IConvertToPostfixNotation converter = new ConvertToPostfixNotation();
        List<String> result = converter.convert(expression);
    }


}
