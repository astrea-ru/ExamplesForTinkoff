package ru.project.calculator;

import org.apache.commons.lang3.StringUtils;
import ru.project.calculator.convertutils.IConvertToPostfixNotation;
import ru.project.calculator.operations.OperationManager;
import ru.project.calculator.operations.TypeOfOperation;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * реализация калькулятора
 */
public class Calculator implements ICalculator {
    private IConvertToPostfixNotation converter;

    public Calculator(IConvertToPostfixNotation converter){
        this.converter = converter;
    }

    @Override
    public double calculate(String expression) throws Exception {
        if (StringUtils.isBlank(expression))
         throw new IllegalArgumentException("Expression is incorrect");

        return result(expression);
    }

    protected double result(String input)
    {
        Stack<String> stack = new Stack<String>();
        Queue<String> queue = new LinkedList<String>(converter.convert(input));
        String curStr = queue.remove();
        while (queue.size() >= 0){
            if (!OperationManager.getInstance().isContains(curStr)){
                stack.push(curStr);
                if (queue.size()>0)
                 curStr = queue.remove();
                else
                    break;
            }
            else{
                double summ = 0;
                try{
                    if (OperationManager.getInstance().getOperation(curStr).getType() == TypeOfOperation.UNARY)
                        summ = OperationManager.getInstance().getOperation(curStr).invoke(new double[] {Double.valueOf(stack.pop())});
                    if (OperationManager.getInstance().getOperation(curStr).getType() == TypeOfOperation.BINARY){
                        double b = Double.valueOf(stack.pop());
                        double a = Double.valueOf(stack.pop());
                        summ = OperationManager.getInstance().getOperation(curStr).invoke(new double[] {a, b});
                    }
                }
                catch (Exception ex){
                    throw new IllegalArgumentException("Introduced an unknown character");
                }
                stack.push(String.valueOf(summ));
                if (queue.size() > 0)
                    curStr = queue.remove();
                else
                    break;
            }

        }

        if (stack.size()==1)
            return Double.valueOf(stack.pop());
        else
            throw new IllegalArgumentException("Expression is incorrect");
    }
}
