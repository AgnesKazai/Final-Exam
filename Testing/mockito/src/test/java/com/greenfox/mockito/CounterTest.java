package com.greenfox.mockito;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;


import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class CounterTest {

    Counter counter;

    DatabaseConnection dbCon = Mockito.mock(DatabaseConnection.class);

    @Before
    public void setUp() throws Exception {
        counter = new Counter(dbCon);
    }

    @Test
    public void sumNumbers() {
        when(dbCon.checkUserPass("Adam", "pass")).thenReturn(true);

        Integer expected = 15;
        assertEquals(expected, counter.sumNumbers("Adam", "pass", 10, 5));
        verify(dbCon).checkUserPass("Adam", "pass");
    }
}
