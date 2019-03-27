package the62_圆圈中最后剩下的数字;

import java.util.LinkedList;

/**
 * 0, 1, … , n-1 这 n 个数字排成一个圈圈，从
 * 数字 0 开始每次从圆圏里删除第 m 个数字。
 * 求出这个圈圈里剩下的最后一个数字。
 * author@ pinnuli
 * date@ 2019/3/27
 */
public class Solution1 {
    /**
     * 经典的解法， 用环形链表模拟圆圈。
     * 创建一个总共有 n 个结点的环形链表，然后每次在这个链表中删除第 m 个结点。
     * 但是这种方法需要在环形链表里面重复遍历很多遍，时间复杂度为O(mn),空间复杂度为S(n)
     * @param n
     * @param m
     * @return
     */
    public int LastRemaining_Solution(int n, int m) {
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int current = 0;
        while (list.size() > 1) {
            current = (current + m - 1) % list.size();
            list.remove(current);
        }
        return list.size() == 1 ? list.get(0) : -1;
    }
}
