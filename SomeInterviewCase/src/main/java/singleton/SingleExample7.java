package singleton;

/**
 * 饿汉模式
 * 单例实例在类装载时进行创建
 * @author: pinnuli
 * @date: 2019-02-15
 */

public class SingleExample7 {

    private SingleExample7() {}

    public static SingleExample7 getInstance() {
        return Singleton.INSTANCE.getSingleton();
    }

    private enum Singleton {
        INSTANCE;

        private SingleExample7 singleton;

        Singleton() {
            singleton = new SingleExample7();
        }

        public SingleExample7 getSingleton() {
            return singleton;
        }
    }
}
