package ru.project.calculator.operations;

import org.junit.Assert;
import org.junit.Test;

public class SubtractionOperationTest {

    private static final double DELTA = 1e-15;

    @Test
    public void method_invoke_returns_correct_result_of_subtraction() throws Exception{
        double [] arg = {5.05, 2.08};
        double correctResult = 2.97;

        IOperation operation = new SubtractionOperation();
        double result = operation.invoke(arg);

        Assert.assertEquals(correctResult, result, DELTA);
    }

    @Test(expected = IllegalArgumentException.class)
    public void method_invoke_throws_IllegalArgumentException_if_number_of_arguments_is_incorrect() throws Exception{
        double[] arg = {1.0};

        IOperation operation = new SubtractionOperation();
        operation.invoke(arg);
    }

    @Test(expected = IllegalArgumentException.class)
    public void method_invoke_throws_IllegalArgumentException_if_args_is_null() throws Exception{
        IOperation operation = new SubtractionOperation();
        operation.invoke(null);
    }
}
