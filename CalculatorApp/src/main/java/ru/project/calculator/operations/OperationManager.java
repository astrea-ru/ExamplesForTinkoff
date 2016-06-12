package ru.project.calculator.operations;

import java.util.HashMap;
import java.util.Map;

/**
 * Менеджер операций. Содержит список всех операций, выполняемых калькулятором.
 */
public class OperationManager {
    private Map<String, IOperation> operation = new HashMap<String, IOperation>();
    private static OperationManager instance = new OperationManager();

    private OperationManager(){
        operation.put("+",new AddOperation());
        operation.put("-",new SubtractionOperation());
        operation.put("*",new MultiplyOperation());
        operation.put("(",new EmptyOperation());
        operation.put(")",new EmptyOperation());
    }

    public static OperationManager getInstance(){
        return instance;
    }
    
    public IOperation getOperation(String key){
        return operation.get(key);
    }
    
    public boolean isContains(String key){
        return operation.containsKey(key);
    }
}

