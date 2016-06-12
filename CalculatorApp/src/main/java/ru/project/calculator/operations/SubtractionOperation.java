package ru.project.calculator.operations;

/**
 * Операция "вычитание"
 */
public class SubtractionOperation extends Operation{

    public SubtractionOperation(){
        super(PriorityOfOperation.SECOND, TypeOfOperation.BINARY);
    }

    public SubtractionOperation(PriorityOfOperation priority){
        super(priority, TypeOfOperation.BINARY);
    }

    @Override
    protected Double getInvocated(double[] arg) {
        return arg[0]-arg[1];
    }
}
