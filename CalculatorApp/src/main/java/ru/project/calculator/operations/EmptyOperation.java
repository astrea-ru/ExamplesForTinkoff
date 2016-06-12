package ru.project.calculator.operations;

/**
 * Пустая операция
 */
public class EmptyOperation extends Operation{

    public EmptyOperation(){
        super(PriorityOfOperation.FOURTH, TypeOfOperation.EMPTY);
    }

    public EmptyOperation(PriorityOfOperation priority){
        super(priority, TypeOfOperation.EMPTY);
    }

    @Override
    protected Double getInvocated(double[] arg) {
        return null;
    }

}
