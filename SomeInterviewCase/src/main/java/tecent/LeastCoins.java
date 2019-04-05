package tecent;

import java.util.Scanner;

/**
 * author@ pinnuli
 * date@ 2019/4/5
 */
public class LeastCoins {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        long[] battles = new long[count];
        int[] coins = new int[count];
        int totalBattles = 0;
        int totalCoins = 0;
        for (int i = 0; i < count; i++) {
            battles[i] = scanner.nextLong();
        }
        for (int i = 0; i < count; i++) {
            coins[i] = scanner.nextInt();
        }
        for (int i = 0; i < count; i++) {
            if (totalBattles < battles[i]) {
                totalCoins += coins[i];
            }
            totalBattles += battles[i];
        }
        System.out.println(totalCoins);
    }
}
