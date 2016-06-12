package ru.project.calculator.operations;

/**
 * Тим выполняемой операции - унарная или бинарная
 */
public enum TypeOfOperation {
    EMPTY(0),
    UNARY(1),
    BINARY(2);
    
    private int value;

    private TypeOfOperation(int value){
        this.value = value;
    }

    public int getValue(){
        return value;
    }
}
