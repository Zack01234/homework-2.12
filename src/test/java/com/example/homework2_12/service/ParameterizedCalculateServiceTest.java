package com.example.homework2_12.service;

import com.example.homework2_12.service.exception.DivideOnZeroException;
import com.example.homework2_12.service.service.CalculateService;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

public class ParameterizedCalculateServiceTest {
    private final CalculateService calculateService = new CalculateService();

    @ParameterizedTest
    @MethodSource("paramsPlus")
    public void plusTest(Integer a, Integer b, Integer expected) {
        assertThat(calculateService.addition(a, b)).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("paramsMinus")
    public void plusTest(Integer a, Integer b, Integer expected) {
        assertThat(calculateService.subtraction(a, b)).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("paramsMultiply")
    public void plusTest(Integer a, Integer b, Integer expected) {
        assertThat(calculateService.multiplication(a, b)).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("paramsDivide")
    public void plusTest(Integer a, Integer b, Double expected) {
        if (b == 0) {
            assertThatExceptionOfType(DivideOnZeroException.class)
                    .isThrownBy(() -> calculateService.division(a, b))
                    .withMessage("На ноль делить нельзя");
        } else {
            assertThat(calculateService.multiplication(a, b)).isEqualTo(expected);
        }
    }

    public static Stream<Arguments> paramsPlus() {
        return Stream.of(
                Arguments.of(1, 2, 3),
                Arguments.of(-1, 2, 1),
                Arguments.of(-10, -6, -16),
                Arguments.of(1, -5, -4),
                Arguments.of(0, 0, 0)
                );
    }

    public static Stream<Arguments> paramsMinus() {
        return Stream.of(
                Arguments.of(-1, -2, 1),
                Arguments.of(-1, 2, -3),
                Arguments.of(-10, -4, -6),
                Arguments.of(1, -4, 5),
                Arguments.of(0, 0, 0)
                );
    }

    public static Stream<Arguments> paramsMultiply() {
        return Stream.of(
                Arguments.of(1, 3, 3),
                Arguments.of(-1, -2, 2),
                Arguments.of(10, 6, 60),
                Arguments.of(1, -5, -5),
                Arguments.of(0, 0, 0)
                );
    }

    public static Stream<Arguments> paramsDivide() {
        return Stream.of(
                Arguments.of(1, 2, 0.5),
                Arguments.of(-1, 2, -0.5),
                Arguments.of(-10, -2, 5),
                Arguments.of(1, 0, null),
                Arguments.of(-1, 0, null)
                );
    }
}
