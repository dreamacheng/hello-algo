package exm.algo;

/**
 * 反转句子中单词顺序（不借助库函数）
 */
public class ReverseString {

    public static void main(String[] args) {
        String str = "hello world sa. asd";
        String reverse = reverseStr(str);
        System.out.println(reverse);
    }

    /**
     * 反转字符串中的单词
     * 先反正整个字符串，再逐个单词反转
     * @param str
     * @return
     */
    public static String reverseStr(String str){
        char[] chars = str.toCharArray();
        reverseString(chars, 0, chars.length - 1);
        int flag = 0;
        for(int i = 0; i < chars.length; ++i){
            if(chars[i] == ' '){
                reverseString(chars, flag, i - 1);
                flag = i + 1;
            }
        }
        reverseString(chars, flag, chars.length - 1);
        String res = String.valueOf(chars);
        return res;
    }

    public static void reverseString(char[] str,int left, int right){
        if(str.length < 1 || left >= right){
            return;
        }
        while ( left < right){
            char temp = str[left];
            str[left++] = str[right];
            str[right--] = temp;
        }
    }
}
