package bigo;

import java.util.Scanner;

/**
 * author@ pinnuli
 * date@ 2019/3/31
 */
public class ReversedString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        for (int i = 0, j = str.length() - 1; i < j; i++, j--) {
            if (str.charAt(i) != str.charAt(j)) {
                System.out.println("false");
                break;
            }
        }
        System.out.println("true");
    }
}
