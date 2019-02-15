package singleton;

/**
 * 懒汉模式
 * 单例实例在第一次使用时进行创建
 * @author: pinnuli
 * @date: 2019-02-15
 */

public class SingleExample3 {

    private SingleExample3() {}

    private static SingleExample3 instance = null;

    public static synchronized SingleExample3 getInstance() {
        if (instance == null) {
            instance = new SingleExample3();
        }
        return instance;
    }
}
