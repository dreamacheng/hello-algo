package exm.algo.interview;

/**
 * 单例模式
 * 懒加载
 */
public class SingletonClass {
    private SingletonClass(){}
    private static class SingletonHandler{
        private static SingletonClass instance = new SingletonClass();
    }
    public static SingletonClass getInstance(){
        return SingletonClass.getInstance();
    }
}
