package ru.project.calculator.operations;

/**
 * Операция "сложение"
 */
public class AddOperation  extends Operation{

    public AddOperation(){
        super(PriorityOfOperation.THIRD, TypeOfOperation.BINARY);
    }

    public AddOperation(PriorityOfOperation priority){
        super(priority, TypeOfOperation.BINARY);
    }

    @Override
    protected Double getInvocated(double[] arg) {
        return arg[0]+arg[1];
    }
}
