package garbage.memoryallocation;

/**
 * @author: linxiaoyi
 * @date: 2021/1/14
 */
// -XX:+PrintGCDetails -Xms20M -Xmx20M -Xmn10M -XX:Survivor-Ratio=8
public class MemoryAllocationByEden {

    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args) {
        testHandlePromotion();
    }

    public static void testAllocation() {
        byte[] allocation1 = new byte[2 * _1MB];
        byte[] allocation2 = new byte[2 * _1MB];
        byte[] allocation3 = new byte[2 * _1MB];
        byte[] allocation4 = new byte[4 * _1MB]; // 出现一次Minor FC
    }

    public static void testPretenureSizeThreshold() {
        byte[] allocation = new byte[4 * _1MB];
    }

    public static void testTenuringThreshold() {
        byte[] allocation1 = new byte[_1MB / 4];
        byte[] allocation2 = new byte[4 * _1MB];
        byte[] allocation3 = new byte[4 * _1MB];
        allocation3 = null;
        allocation3 = new byte[4 * _1MB];
    }

    public static void testTenuringThreshold2() {
        byte[] allocation1 = new byte[_1MB / 4];
        byte[] allocation2 = new byte[_1MB / 4];
        byte[] allocation3 = new byte[4 * _1MB];
        byte[] allocation4 = new byte[4 * _1MB];
        allocation4 = null;
        allocation4 = new byte[4 * _1MB];
    }

    public static void testHandlePromotion() {
        byte[] allocation1 = new byte[2 * _1MB];
        byte[] allocation2 = new byte[2 * _1MB];
        byte[] allocation3 = new byte[2 * _1MB];
        allocation1 = null;
        byte[] allocation4 = new byte[2 * _1MB];
        byte[] allocation5 = new byte[2 * _1MB];
        byte[] allocation6 = new byte[2 * _1MB];
        allocation4 = null;
        allocation5 = null;
        allocation6 = null;
        byte[] allocation7 = new byte[2 * _1MB];
    }
}
