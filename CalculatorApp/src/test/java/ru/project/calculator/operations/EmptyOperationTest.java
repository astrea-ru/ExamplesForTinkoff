package ru.project.calculator.operations;

import org.junit.Assert;
import org.junit.Test;

public class EmptyOperationTest {
    @Test
    public void method_invoke_returns_null_for_empty_operation() throws Exception{
        IOperation operation = new EmptyOperation();
        Double result = operation.invoke(new double[0]);

        Assert.assertNull(result);
    }

    @Test
    public void method_invoke_returns_null_for_empty_operation_if_args_is_null() throws Exception{
        IOperation operation = new EmptyOperation();
        Double result = operation.invoke(null);

        Assert.assertNull(result);
    }
    
    @Test
    public void method_getPriority_returns_priority_of_operation(){
        IOperation operation = new EmptyOperation(PriorityOfOperation.SIXTH);

        Assert.assertEquals(PriorityOfOperation.SIXTH, operation.getPriority());
    }

    @Test
    public void method_getType_returns_type_of_operation(){
        IOperation operation = new EmptyOperation();

        Assert.assertEquals(TypeOfOperation.EMPTY, operation.getType());
    }
}
