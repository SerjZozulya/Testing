package Calculations;

import java.math.BigDecimal;
import java.math.BigInteger;

public class Calculator {
    public BigDecimal sum(BigDecimal a, BigDecimal b) {
        return a.add(b);
    }

    public double subtract(double a, double b) {
        return a-b;
    }

    public double multiply(double a, double b) {
        return a*b;
    }

    public double divide(double a, double b) {
        if (b != 0)
            return a/b;
        else throw new ArithmeticException();
    }

    public BigInteger factorial(int a) throws ArithmeticException {
        BigInteger result = new BigInteger("1");
        if (a == 0 || a == 1)
            return result;
        else {
            if(a >= 0) {
                while (a > 1) {
                    result = result.multiply(BigInteger.valueOf(a));
                    a--;
                }
                return result;
            }
            else throw new ArithmeticException();
        }
    }
}
