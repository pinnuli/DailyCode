package cvte.decrypt;

/**
 * @author: pinnuli
 * @date: 2019-01-14
 */

public class Decrypt {
    public void decrypt(String encryptStr) {
        StringBuffer decryptStr = new StringBuffer();
        for(int i = 0; i < encryptStr.length(); i++) {
            char temp = (char)('A' + encryptStr.charAt(i) - 1);
            decryptStr.setCharAt(i, temp );
            String a = "123";
            int b = Integer.valueOf(a);
        }
    }
}
