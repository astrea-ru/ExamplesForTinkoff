package ru.project.calculator.operations;

import org.junit.Assert;
import org.junit.Test;

public class OperationManagerTest {

    @Test
    public void isContains_checks_operation_by_key(){
        OperationManager manager = OperationManager.getInstance();

        Assert.assertTrue(manager.isContains("*"));
        Assert.assertTrue(manager.isContains("+"));
        Assert.assertTrue(manager.isContains("-"));
        Assert.assertTrue(manager.isContains("("));
        Assert.assertTrue(manager.isContains(")"));
    }

    @Test
    public void getOperation_returns_operation_by_key(){
        OperationManager manager = OperationManager.getInstance();

        Assert.assertEquals(AddOperation.class,manager.getOperation("+").getClass());
        Assert.assertEquals(MultiplyOperation.class,manager.getOperation("*").getClass());
        Assert.assertEquals(SubtractionOperation.class,manager.getOperation("-").getClass());
        Assert.assertEquals(EmptyOperation.class,manager.getOperation("(").getClass());
        Assert.assertEquals(EmptyOperation.class,manager.getOperation(")").getClass());
    }
}
