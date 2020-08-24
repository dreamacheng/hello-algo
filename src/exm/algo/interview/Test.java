package exm.algo.interview;

import java.util.Arrays;

public class Test {

    /**
     * 根据上排给出十个数，在其下排填出对应的十个数，要求下排每个数都是先前上排那十个数在下排出现的次数。
     * 上排的十个数如下：【0，1，2，3，4，5，6，7，8，9】。
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = new int[10];

        for (int i = 0; i < 10; i++) { // 初始状态
            arr[i] = i;
        }
        boolean flag = false;
        int num;
        while (!flag ) {
            flag = true;
            for (int i = 0; i < 10; i++) {
                num = 0;
                for (int j = 0;j < 10; j++) { // 统计次数
                    if ( arr[j] != i)
                        continue;
                    num++;
                }
                if ( num != arr[i]) flag = false;
                arr[i] = num; // 修正次数
            }
        }
        // 当无需修正时跳出循环
        System.out.println(Arrays.toString(arr));
    }
}
