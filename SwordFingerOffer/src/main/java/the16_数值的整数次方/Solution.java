package the16_数值的整数次方;

/**
 * @author: pinnuli
 * @date: 2019-02-19
 */

public class Solution {

    public double Power(double base, int exponent) {
        if (base == 0 && exponent < 0) {
            throw new RuntimeException("分母不可为0");
        }

        int absExponent = exponent < 0 ? 0 - exponent : exponent;

        double result = powerWithUnsignedExponent(base, absExponent);
        return exponent < 0 ? 1 / result : result;
    }

    public double powerWithUnsignedExponent(double base, int absExponent) {
        if (absExponent == 0) {
            return 1;
        }

        double result = powerWithUnsignedExponent(base, absExponent >> 1);
        result *= result;
        if ((absExponent & 1) == 1) {
            result *= base;
        }
        return result;
    }
}
