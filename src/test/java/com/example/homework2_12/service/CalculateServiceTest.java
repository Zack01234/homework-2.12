package com.example.homework2_12.service;

import com.example.homework2_12.service.exception.DivideOnZeroException;
import com.example.homework2_12.service.service.CalculateService;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

public class CalculateServiceTest {
    private final CalculateService calculateService = new CalculateService() {
        @Override
        public int addition(Integer a, Integer b) {
            return 0;
        }

        @Override
        public int subtraction(Integer a, Integer b) {
            return 0;
        }

        @Override
        public int multiplication(Integer a, Integer b) {
            return 0;
        }

        @Override
        public double division(Integer a, Integer b) {
            return 0;
        }
    };

    @Test
    public void plusTest() {
        Number actual = calculateService.addition(3, 4);
        assertThat(actual).isEqualTo(7);
        actual = calculateService.addition(-4, 1);
        assertThat(actual).isEqualTo(-3);
    }

    @Test
    public void minusTest() {
        Number actual = calculateService.subtraction(3, 4);
        assertThat(actual).isEqualTo(-1);
        actual = calculateService.subtraction(-4, 1);
        assertThat(actual).isEqualTo(-5);
    }

    @Test
    public void multiplyTest() {
        Number actual = calculateService.multiplication(3, 4);
        assertThat(actual).isEqualTo(12);
        actual = calculateService.multiplication(-4, 1);
        assertThat(actual).isEqualTo(-4);
    }

    @Test
    public void dividePositiveTest() {
        Number actual = calculateService.division(4, 4);
        assertThat(actual).isEqualTo(1);
        actual = calculateService.division(-4, 1);
        assertThat(actual).isEqualTo(-4);
    }

    @Test
    public void divideNegativeTest() {
        assertThatExceptionOfType(DivideOnZeroException.class)
                .isThrownBy(() -> calculateService.division(1, 0))
                .withMessage("На ноль делить нельзя");
        assertThatExceptionOfType(DivideOnZeroException.class)
                .isThrownBy(() -> calculateService.division(-1, 0))
                .withMessage("На ноль делить нельзя");
    }
}
