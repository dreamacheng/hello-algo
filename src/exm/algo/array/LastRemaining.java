package exm.algo.array;

public class LastRemaining {

    public static void main(String[] args) {
        System.out.println(lastRemaining2(10, 9));
    }


    // 暴力超时
    public static int lastRemaining(int n, int m) {
        int[] rest = new int[n];
        int cnt = 1;
        for (int i = 0, len = rest.length; n > 1; i++) {
            if (rest[i%len] == -1) {
                continue;
            }
            if (cnt%m == 0) {
                rest[i%len] = -1;
                n--;
            }
            cnt++;
        }
        for (int i = 0; i < rest.length; i++) {
            if (rest[i] == 0) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 约瑟夫环
     * f(n,m) = ((m-1)%n + f(n-1,m) + 1) % n
     *        = ((m-1)%n%n + (f(n-1,m)+1)%n)%n
     *        = (m + f(n-1,m))%n
     */
    public static int lastRemaining2(int n, int m) {
        int f = 0;
        for (int i = 2; i <= n; i++) {
            // 两个定理
            // 1. (a + b)%c = (a%c + b%c)%c
            // 2. a%c = a%c%c
            f = (f + m) % i;
        }
        return f;
    }
}
