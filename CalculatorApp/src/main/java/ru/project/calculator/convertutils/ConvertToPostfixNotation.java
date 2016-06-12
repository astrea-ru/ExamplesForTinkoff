package ru.project.calculator.convertutils;

import ru.project.calculator.operations.IOperation;
import ru.project.calculator.operations.OperationManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


/**
 * Класс для выполнения конвертации выражения в постфиксную запись
 */
public class ConvertToPostfixNotation implements IConvertToPostfixNotation{
    private static final String OPEN_BRACKET = "(";
    private static final String CLOSE_BRACKET = ")";
    private static final char DELIMITER = '.';
    private static final char COMMA_SEPARATOR = ',';


    @Override
    public List<String> convert(String input) throws IllegalArgumentException{
        input = input.replace(" ","");

        List<String> outputSeparated = new ArrayList<String>();
        Stack<String> stack = new Stack<String>();
        for (String curStr: Separate(input)){
            if (OperationManager.getInstance().isContains(curStr)){
                IOperation curOperation = OperationManager.getInstance().getOperation(curStr);
                if (stack.size() > 0 && !curStr.equals(OPEN_BRACKET)){
                    IOperation lastOperation = OperationManager.getInstance().getOperation(stack.peek());
                    if (curStr.equals(CLOSE_BRACKET)){
                        String s = stack.pop();
                        while (!s.equals(OPEN_BRACKET)){
                            outputSeparated.add(s);
                            s = stack.pop();
                        }
                    }
                    else if (curOperation.getPriority().comparePriorityTo(lastOperation.getPriority())>-1)
                        stack.push(curStr);
                    else{
                        while (stack.size() > 0 && curOperation.getPriority().comparePriorityTo(lastOperation.getPriority())==-1)
                            outputSeparated.add(stack.pop());
                        stack.push(curStr);
                    }
                }
                else
                    stack.push(curStr);
            }
            else
                outputSeparated.add(curStr);
        }
        while (stack.size()>0)  {
            String element = stack.pop();
            if (element.equals(OPEN_BRACKET) || (element.equals(CLOSE_BRACKET)))
                throw new IllegalArgumentException("Expression is incorrect");
            outputSeparated.add(element);
        }

        return outputSeparated;
    }

    /**
     * Метод для разбиения вычисляемого выражения на составляющие
     * @param input
     * @return
     */
    private List<String> Separate(String input)
    {
        List<String> result = new ArrayList<String>();
        int pos = 0;
        while (pos < input.length()){
            String s = ""+input.charAt(pos);
            if (! OperationManager.getInstance().isContains(String.valueOf(input.charAt(pos))))
            {
                if (Character.isDigit(input.charAt(pos)))
                    for (int i = pos + 1; i < input.length() &&
                            (Character.isDigit(input.charAt(i)) || input.charAt(i) == COMMA_SEPARATOR || input.charAt(i) == DELIMITER); i++)
                        s += input.charAt(i);
                else if (Character.isLetter(input.charAt(pos)))
                    for (int i = pos + 1; i < input.length() &&
                            (Character.isLetter(input.charAt(i)) || Character.isDigit(input.charAt(i))); i++)
                        s += input.charAt(i);
            }
            result.add(s);
            pos += s.length();
        }
        return result;
    }
}
