package tecent;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * author@ pinnuli
 * date@ 2019/4/5
 */
public class DeleteZeroAndOne {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        ArrayList<Character> list = new ArrayList<>(count);
        String str = scanner.next();
        char[] numbers = str.toCharArray();
        for (int i = 0; i < count; i++) {
            list.add(numbers[i]);
            int sizeOfList = list.size();
            if (sizeOfList >= 2) {
                boolean isMatch = (list.get(sizeOfList - 1) == '0' && list.get(sizeOfList - 2) == '1')
                        || (list.get(sizeOfList - 1) == '1' && list.get(sizeOfList - 2) == '0');
                if (isMatch) {
                    list.remove(sizeOfList - 1);
                    list.remove(sizeOfList - 2);
                }
            }
        }
        System.out.println(list.size());
    }
}
