package ru.project.calculator.operations;

public abstract class Operation implements IOperation {
   protected PriorityOfOperation priority;
   protected TypeOfOperation type;

    public Operation(PriorityOfOperation priority, TypeOfOperation type ){
           this.priority = priority;
           this.type = type;
    }

    @Override
    public Double invoke(double[] arg) throws Exception {
        if (((arg!=null)&&(arg.length==type.getValue())) ||
            (arg==null && type == TypeOfOperation.EMPTY))
            return getInvocated(arg);
        else
            throw new IllegalArgumentException("Incorrect number of arguments");
    }

    @Override
    public PriorityOfOperation getPriority() {
        return priority;
    }

    @Override
    public TypeOfOperation getType() {
        return type;
    }

    /**
     * Получить результат выполнения операции
     *
     * @param arg
     * @return
     */
    protected abstract Double getInvocated(double[] arg);
}
