package exm.algo.interview;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class ReflectSubject {
    /**
     * 使用反射往集合中加入不同类型的成员
     * 当取到非声明类型成员，抛出ClassCastException
     * 未访问非声明类型成员，程序正常运行
     */
    public static void main(String[] args) throws NoSuchMethodException {
        List<String> list = new ArrayList<String>();
        list.add("a");
        list.add("b");
        Method add = ArrayList.class.getDeclaredMethod("add", Object.class);
        try {
            add.invoke(list, new Integer(1));
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        System.out.println(list.get(2));
    }
}
