package com.davault.fullstack;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class FullStackAmigoApplicationTests {

    Calculator underTest = new Calculator();
    class Calculator {

        public int add(int a, int b) {
            return a + b;
        }

    }

    @Test
    void shouldAddTwoNumbers() {
        //given
        int numOne = 20;
        int numTwo = 30;
        int expected = 50;

        //When
        int actual = underTest.add(numOne, numTwo);

        //Then
        assertThat(actual).isEqualTo(expected);
    }

}
