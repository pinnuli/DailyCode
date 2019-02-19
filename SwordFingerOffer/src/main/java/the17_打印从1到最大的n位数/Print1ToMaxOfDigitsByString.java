package the17_打印从1到最大的n位数;

/**
 * @author: pinnuli
 * @date: 2019-02-19
 */

public class Print1ToMaxOfDigitsByString {

    /**
     * 使用字符串
     * @param n 位数
     */
    public void print1ToMaxOfDigitsByString(int n) {
        if (n <= 0) {
            return;
        }

        char[] number = new char[n];
        for (int i = 0; i < n; i++) {
            number[i] = '0';
        }
        while (!increment(number)) {
            printNumber(number);
        }
    }



    public boolean increment(char[] number) {
        boolean overFlow = false;

        int nTakeOver = 0;
        int nLength = number.length;
        for (int i = nLength - 1; i >= 0; i--){
            int nSum = number[i] - '0' + nTakeOver;
            if (i == nLength - 1) {
                nSum ++;
            }
            if (nSum >= 10) {
                if (i == 0) {
                    overFlow = true;
                } else {
                    nSum -= 10;
                    nTakeOver = 1;
                    number[i] = (char)('0' + nSum);
                }
            } else {
                number[i] = (char)('0' + nSum);
                break;
            }
        }
        return overFlow;
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
