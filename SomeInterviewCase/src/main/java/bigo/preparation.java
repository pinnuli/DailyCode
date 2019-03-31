package bigo;

import java.util.Scanner;

/**
 * author@ pinnuli
 * date@ 2019/3/31
 */
public class preparation {
    public static void inputInt(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] num = new int[N];
        for (int i = 0; i < N; i++) {
            num[i] = sc.nextInt();
        }
//System.out.println("hallo");
    }

    public static void InputStr(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        char[] arr = str.toCharArray();
    }


}
