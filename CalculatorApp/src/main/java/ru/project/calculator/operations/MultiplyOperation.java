package ru.project.calculator.operations;

/**
 * Операция "умножение"
 */
public class MultiplyOperation  extends Operation{

    public MultiplyOperation(){
        super(PriorityOfOperation.FIRST, TypeOfOperation.BINARY);
    }

    public MultiplyOperation(PriorityOfOperation priority){
        super(priority, TypeOfOperation.BINARY);
    }

    @Override
    protected Double getInvocated(double[] arg) {
        return arg[0]*arg[1];
    }
}
