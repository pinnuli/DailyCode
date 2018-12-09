package PrimeNumber;

/**
 * @author: pinnuli
 * @date: 2018-12-09
 */

public class PrimeNumberInThousand {
    private static void primeNumber() {
        boolean flag = false;
        for (int i = 2; i <= 1000; i++) {
            flag = false;
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                System.out.println(i);
            }
        }
    }

    public static void main(String[] args) {
        primeNumber();
    }
}
