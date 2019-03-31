package bigo;

import java.util.Scanner;

/**
 * author@ pinnuli
 * date@ 2019/3/31
 */

/**
 * 输入描述:
 * 输入包括n+1行：
 * 第一行为单词个数n(1 ≤ n ≤ 50)
 * 接下来的n行，每行一个单词word[i]，长度length(1 ≤ length ≤ 50)。由小写字母构成
 * 输出描述:
 * 输出循环单词的种数
 * 输入例子:
 * 5
 * picture
 * turepic
 * icturep
 * word
 * ordw
 * 输出例子:
 * 2
 */
public class Demo1 {
    private int N;
    private String[] arr;
    private int count;

    public static void main(String[] args) {
        Demo1 demo = new Demo1();
        Scanner sc = new Scanner(System.in);
        demo.N = sc.nextInt();
        demo.arr = new String[demo.N];
        for (int i = 0; i < demo.N; i++) {
            String str = sc.next();
            demo.solve(str);
        }
        System.out.println(demo.count);
        for (int i = 0; i < demo.count; i++) {
            System.out.println(demo.arr[i]);
        }
        sc.close();
    }

    private void solve(String str) {
        if (count == 0) {
            arr[0] = str + str;
            count++;
            return;
        }
        boolean flag = false;
        int num = count;
        for (int i = 0; i < num; i++) {
            //如果包含该单词，吧flag设置成ture，循环结束要记得把flag重新设置成false
            if (judge(arr[i], str)) {
                flag = true;
                break;
            }
        }
        if (flag != true) {
            arr[count++] = str + str;
        }
        flag = false;
    }

    /*
     * 如果str1包含str2.则返回true
     */
    private boolean judge(String str1, String str2) {
        if (str1.length() == str2.length()) {
            return false;
        }
        //这里必须要验证str2是否为str1的一半，否则会无法通过
        return str1.contains(str2) && str1.length() == str2.length() * 2;
    }

}
