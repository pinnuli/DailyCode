package cvte.matchIP;

/**
 * @author: pinnuli
 * @date: 2019-01-14
 */

public class MatchIP {

    public static boolean matchIPV4(String IP) {
        String[] numbers = IP.split(".");
        if (numbers.length == 4) {
            for (int i = 0; i < numbers.length; i++) {
                try {
                    if (Integer.valueOf(numbers[i]) < 0 || Integer.valueOf(numbers[i]) > 255) {
                        return false;
                    }
                } catch (Exception e) {
                    return false;
                }

            }
        } else {
            return false;
        }
        return true;
    }

    public static boolean matchIPV6(String IP) {
        String[] letters = IP.split(":");
        if (IP.length() == 8) {
            for (int i= 0; i < letters.length; i++) {
                if (letters[i].equals("")){
                    return false;
                } else {
                    for (int j = 0; j < letters[i].length(); j++) {
                        if (letters[i].charAt(j) < '0'
                                || (letters[i].charAt(j) > '9' && letters[i].charAt(j) < 'A')
                                || (letters[i].charAt(j) > 'Z' && letters[i].charAt(j) < 'a')
                                || letters[i].charAt(j) > 'z') {
                            return false;
                        }
                    }
                }
            }
        } else {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String IP = "255.255.255.255";
        if (matchIPV4(IP)) {
            System.out.println("IPV4");
        } else if (matchIPV6(IP)) {
            System.out.println("IPV6");
        } else {
            System.out.println("Neither");
        }
    }
}
