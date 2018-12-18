package ConcurrentSort;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author: pinnuli
 * @date: 2018-12-17
 */

public class Qsort {
    //创建线程池
    ExecutorService pool = Executors.newFixedThreadPool(6);

    private int[] str = null;

    public Qsort(int str[]) {
        this.str = str;
        sort(0, str.length - 1);
    }

    //分治
    public void sort(int begin, int end) {
        //Future用来接收返回值
        Future<temp> future = pool.submit(new MyThread(begin, end, str));
        try {
            if (future.get().cmpLeftMiddle()) {
                sort(future.get().getLeft(), future.get().getMiddle() - 1);
            }
            if (future.get().cmpMiddleRight()) {
                sort(future.get().getMiddle() + 1, future.get().getRight());
            }
        } catch (InterruptedException e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        } catch (ExecutionException e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {

        int a[] = new int[1024];
        for (int i = 0; i < 1024; i++) {
            a[i] = (int) (Math.random() * 1000);
            System.out.print(a[i] + " ");
        }
        System.out.println();

        long star = System.currentTimeMillis();
        new Qsort(a);
        //  new quicksort().sort(0, a.length-1, a);
        long end = System.currentTimeMillis();
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
        System.out.println(end - star);
    }
}
