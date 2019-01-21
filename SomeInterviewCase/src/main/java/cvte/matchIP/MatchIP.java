package cvte.matchIP;

/**
 *
 * IPv4地址以十进制表示方法表示,它由四个十进制数组成,每个数字范围从0到255,以”.”分割,
 * 例如172.16.254.1:以此表示,此外IPv4的前导零无效.例如:172.16.255.01无效
 * IPv6地址表示为八组四个十六进制数字,每组代表16位,这些组用冒号”:”分割.
 * 例如:2001:0db8:85a3:0000:0000:8a2e:0370:7334是一个有效的地址.
 * 此外,我们可以省略四个十六进制数字中的一些前导零和忽略大小写,所以2001:0db8:85a3:0000:0000:8a2e:0370:7334也是一个有效的ipv6地址,
 * 省略前导零和使用大写字母.
 * 然而,我们不适用两个连续的冒号”:”来使用单个空组来替换零值的连续组,以追求简单性,
 * @author: pinnuli
 * @date: 2019-01-14
 */

public class MatchIP {

    public static boolean matchIPV4(String IP) {
        String[] numbers = IP.split("\\.");
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
        if (letters.length == 8) {
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
        String IP = "2001:0db8:85a3:0000:0000:8a2e:0370:7334";
        if (matchIPV4(IP)) {
            System.out.println("IPV4");
        } else if (matchIPV6(IP)) {
            System.out.println("IPV6");
        } else {
            System.out.println("Neither");
        }
    }
}
