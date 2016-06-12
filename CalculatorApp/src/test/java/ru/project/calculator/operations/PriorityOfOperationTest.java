package ru.project.calculator.operations;

import org.junit.Assert;
import org.junit.Test;

public class PriorityOfOperationTest {
    @Test
    public void comparePriorityTo_returns_zero_if_priorities_is_equals(){
         PriorityOfOperation priority = PriorityOfOperation.FIFTH;

        int result = priority.comparePriorityTo(PriorityOfOperation.FIFTH);

        Assert.assertEquals(0, result);
    }

    @Test
    public void comparePriorityTo_returns_1_if_current_priority_is_higher(){
        PriorityOfOperation priority = PriorityOfOperation.SECOND;

        int result = priority.comparePriorityTo(PriorityOfOperation.FIFTH);

        Assert.assertEquals(1, result);
    }

    @Test
    public void comparePriorityTo_returns_a_minus_one_if_current_priority_is_lower(){
        PriorityOfOperation priority = PriorityOfOperation.FIFTH;

        int result = priority.comparePriorityTo(PriorityOfOperation.SECOND);

        Assert.assertEquals(-1, result);
    }
}
