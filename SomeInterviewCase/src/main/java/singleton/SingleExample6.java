package singleton;

/**
 * 饿汉模式
 * 单例实例在类装载时进行创建
 * @author: pinnuli
 * @date: 2019-02-15
 */

public class SingleExample6 {

    private SingleExample6() {}

    private static SingleExample6 instance = null;

    static {
        instance = new SingleExample6();
    }

    public static SingleExample6 getInstance() {
        return instance;
    }
}
