package ru.project.calculator.operations;

import org.junit.Assert;
import org.junit.Test;

public class AddOperationTest {
    private static final double DELTA = 1e-15;

    @Test
    public void method_invoke_returns_correct_result_of_subtraction() throws Exception{
        double[] arg = {3.08, 3.58};
        double correctResult = 6.66;

        IOperation operation = new AddOperation();
        double result = operation.invoke(arg);

        Assert.assertEquals(correctResult, result, DELTA);
    }

    @Test(expected = IllegalArgumentException.class)
    public void method_invoke_throws_IllegalArgumentException_if_number_of_arguments_is_incorrect() throws Exception{
        double[] arg = {3.08};

        IOperation operation = new AddOperation();
        operation.invoke(arg);
    }

    @Test(expected = IllegalArgumentException.class)
    public void method_invoke_throws_IllegalArgumentException_if_args_is_null() throws Exception{
        IOperation operation = new AddOperation();
        operation.invoke(null);
    }
}
