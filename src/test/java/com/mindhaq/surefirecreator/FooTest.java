package com.mindhaq.surefirecreator;

import org.junit.Assert;
import org.junit.Test;

public class FooTest {

    @Test
    public void bar() {
        assert true;
    }

    @Test
    public void err() {
        throw new RuntimeException("failed!");
    }

    @Test
    public void fail() {
        Assert.fail("This test failed.");
    }

}
