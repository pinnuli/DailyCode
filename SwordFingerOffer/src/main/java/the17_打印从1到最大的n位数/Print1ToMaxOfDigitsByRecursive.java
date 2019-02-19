package the17_打印从1到最大的n位数;

/**
 * @author: pinnuli
 * @date: 2019-02-19
 */

public class Print1ToMaxOfDigitsByRecursive {
    /**
     * 递归
     * @param n 位数
     */
    public void print1ToMaxOfDigitsByRecursive(int n) {
        if (n <= 0) {
            return;
        }

        char[] number = new char[n];
        for (int i = 0; i < n; i++) {
            number[i] = '0';
        }
        print1ToMaxOfDigitsRecursively(number, number.length, 0);
    }

    public void print1ToMaxOfDigitsRecursively(char[] number, int length, int index) {
        if (index == length) {
            printNumber(number);
            return;
        }
        for (int i = 0; i < 10; i++) {
            number[index] = (char)(i + '0');
            print1ToMaxOfDigitsRecursively(number, length, index + 1);
        }
    }
    public void printNumber(char[] number) {
        boolean isBegining0 = true;
        for (int i = 0; i < number.length; i++) {
            if (isBegining0 && number[i] != '0') {
                isBegining0 = false;
            }
            if (!isBegining0) {
                System.out.print(number[i]);
            }
        }
        System.out.println();
    }
}
