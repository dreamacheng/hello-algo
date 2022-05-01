package exm.algo.string;

/**
 * leetcode-url:
 * https://leetcode-cn.com/problems/longest-absolute-file-path/
 * 文件的最长绝对路径
 */
public class LengthLongestPath {

    public int lengthLongestPath(String input) {
        if (!input.contains(".")) {
            return 0;
        }
        int rest = 0;
        String[] split = input.split("\\n");
        int[] tCountArr = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            String[] filePath = split[i].split("\\t");
            int tCount = filePath.length - 1;
            tCountArr[i] = tCount;
            if (!split[i].contains(".")) {
                continue;
            }
            StringBuilder path = new StringBuilder(filePath[filePath.length - 1]);
            for (int j = i - 1; j >= 0; j--) {
                if (tCountArr[j] == tCount - 1 && !split[j].contains(".")) {
                    path.insert(0, split[j].replaceAll("\t", "") + "/");
                    tCount--;
                }
            }
            rest = Math.max(path.length(), rest);
        }
        return rest;
    }
}
