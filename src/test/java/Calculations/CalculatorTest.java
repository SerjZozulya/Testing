package Calculations;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.BigInteger;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CalculatorTest {

    Calculator calculator = new Calculator();

    @Test
    void sumOfSmallNumbersTest() {
        assertThat("Проверка сложения малых чисел",
            calculator.sum(new BigDecimal("0.00000001"), new BigDecimal("0.00000007")),
            equalTo(new BigDecimal("0.00000008")));
    }

    @Test
    void sumOfBigNumbersTest() {
        assertThat("Проверка целочисленного сложения",
            calculator.sum(new BigDecimal("9999999999998.9"), new BigDecimal("1.1")),
            equalTo(new BigDecimal("10000000000000.0")));
    }

    @Test
    void subtractTest() {
        assertThat("Проверка целочисленного вычитания",
            calculator.subtract(2, 3),
            equalTo(-1.0));
    }

    @Test
    void multiply() {
        assertThat("Проверка целочисленного умножения",
            calculator.multiply(2, 3),
            equalTo(6.0));
    }

    @Test
    void divide() {
        assertThat("Проверка деления",
            calculator.divide(3, -2),
            equalTo(-1.5));
    }

    @Test
    void factorialOfBigNumberTest() {
        assertThat("Проверка факториала",
            calculator.factorial(21),
            equalTo(new BigInteger("51090942171709440000")));
    }

    @Test
    void divideByZeroTest() {
        assertThrows(ArithmeticException.class,
            () -> calculator.divide(5, 0),
            "Проверка деления на ноль");
    }

    @Test
    void  multiplyByZeroTest() {
        assertThat("Проверка умножения на 0",
            calculator.multiply(3, 0),
            equalTo(0.0));
    }

    @Test()
    void  factorialOfNegativeNumberTest() {
        assertThrows(ArithmeticException.class,
            () -> calculator.factorial(-5), "Проверка подсчёта факториала отрицательного числа");
    }

    @Test
    void factorialOfZeroTest() {
        assertThat("Проверка подсчёта факториала нуля",
            calculator.factorial(0),
            equalTo(new BigInteger("1")));
    }
}