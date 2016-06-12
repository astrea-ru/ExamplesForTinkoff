package ru.project.calculator;

import ru.project.calculator.convertutils.ConvertToPostfixNotation;


/**
 * точка входа в приложение
 */
public class CalculatorApp {
    public static void main(String[] args) throws Exception
    {
        String input=null,result=null;
        if ((args!=null) && (args.length>0)){
            input = args[0];
        }
        ICalculator calculator = new Calculator(new ConvertToPostfixNotation());

        try{
            result = String.format("Result: %.2f", calculator.calculate(input));
        }catch (Exception exception){
            result = exception.getMessage();
        }

        System.out.println(result);
    }
}
