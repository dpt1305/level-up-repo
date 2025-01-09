package com.example.bt8.bt8;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Bt8ApplicationTests {
	@Autowired
	private ICalculator calcualtor;

	@Test
    public void testCase1() {
        int a = 1;
        int b = 2;

        int actualResult = calcualtor.sum2Number(a, b);
        assertEquals(actualResult, 3);
    }

    @Test
    public void testCase2() {
        int a = 100;
        int b = 2000;

        int actualResult = calcualtor.sum2Number(a, b);
        assertEquals(actualResult, 2100);
    }

}
