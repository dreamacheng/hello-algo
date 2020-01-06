package exm.algo.interview;

public class StringSubject {
    /**
     * 无论是基本类型还是引用类型，方法参数传递都为局部变量，
     * 传递参数为基本类型时，只有值传递
     * 传递参数为引用类型时，传递内存地址，符号引用仍为局部变量，当对传递参数使用new操作时，不改变传入对象的地址指向，只是将形式参数指向新new的内存空间
     */
    public static void main(String[] args) {
        System.out.println("hello world");
        StringBuffer sb = new StringBuffer("world");
        System.out.println("hello " + sb);
        change(sb);
        System.out.println("hello " + sb);
    }

    private static void change(StringBuffer sb) {
        sb = new StringBuffer("change");
    }
}
