package com.pinnuli.leetcode.Test;

/**
 * @author linxiaoyi
 * @date 2021/3/19
 */
public class Bitmap {
    private char[] bytes;
    private int nbits;

    public Bitmap(int nbits) {
        this.nbits = nbits;
        this.bytes = new char[nbits / 8 + 1];
    }

    public void set(int k) {
        if (k > nbits) return;
        int byteIndex = k / 8;
        int bitIndex = k % 8;
        bytes[byteIndex] |= (1 << bitIndex);
    }

    public boolean get(int k) {
        if (k > nbits) return false;
        int byteIndex = k / 8;
        int bitIndex = k % 8;
        return (bytes[byteIndex] & (1 << bitIndex)) != 0;
    }
}