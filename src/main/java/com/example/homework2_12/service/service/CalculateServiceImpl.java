package com.example.homework2_12.service.service;

import com.example.homework2_12.service.exception.DivideOnZeroException;
import org.springframework.stereotype.Service;

@Service
public class CalculateServiceImpl implements CalculateService {
    @Override
    public int addition(Integer a, Integer b) {
        return a + b;
    }

    @Override
    public int subtraction(Integer a, Integer b) {
        return a - b;
    }

    @Override
    public int multiplication(Integer a, Integer b) {
        return a * b;
    }

    @Override
    public double division(Integer a, Integer b) {
        if (b == 0) {
            throw new DivideOnZeroException("На ноль делить нельзя");
        }
        return a.doubleValue() / b;
    }
}