package ru.project.calculator.operations;

import org.junit.Assert;
import org.junit.Test;

public class MultiplyOperationTest {
    private static final double DELTA = 1e-14;

    @Test
    public void method_invoke_returns_correct_result_of_multiply() throws Exception{
        double [] arg = {3.08,5.2};
        double correctResult = 16.016;

        IOperation operation = new MultiplyOperation();
        double result = operation.invoke(arg);

        Assert.assertEquals(correctResult, result, DELTA);
    }

    @Test(expected = IllegalArgumentException.class)
    public void method_invoke_throws_IllegalArgumentException_if_number_of_arguments_is_incorrect() throws Exception{
        double[] arg = {1.0,2.0,3.0};

        IOperation operation = new MultiplyOperation();
        operation.invoke(arg);
    }

    @Test(expected = IllegalArgumentException.class)
    public void method_invoke_throws_IllegalArgumentException_if_args_is_null() throws Exception{
        IOperation operation = new MultiplyOperation();
        operation.invoke(null);
    }
}
