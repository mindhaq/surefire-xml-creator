package com.mindhaq.surefirecreator;

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

}
