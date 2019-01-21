package cvte.fullPermutation;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * @author: pinnuli
 * @date: 2019-01-15
 */

public class FullPermutation {
    public static void allPermutation(String str){
        if(str == null || str.length() == 0)
            return;
        //保存所有的全排列
        LinkedList<String> listStr = new LinkedList<String>();

        allPermutation(str.toCharArray(), listStr, 0);

        print(listStr);//打印全排列
    }


    private static void allPermutation(char[] c, LinkedList<String> listStr, int start){


        if(start == c.length-1)
            listStr.add(String.valueOf(c));
        else{
            for(int i = start; i <= c.length-1; i++)
            {
                swap(c, i, start);//相当于: 固定第 i 个字符
                allPermutation(c, listStr, start+1);//求出这种情形下的所有排列
//                swap(c, start, i);//复位
            }
        }
    }

    private static void swap(char[] c, int i, int j){
        char tmp;
        tmp = c[i];
        c[i] = c[j];
        c[j] = tmp;
    }

    private static void print(LinkedList<String> listStr)
    {
        Collections.sort(listStr);//使字符串按照'字典顺序'输出
        for (String str : listStr) {
            System.out.println(str);
        }
        System.out.println("size:" + listStr.size());
    }

    //hapjin test
    public static void main(String[] args) {
//        allPermutation("hapjin");
        allPermutation("abc");
    }
}
