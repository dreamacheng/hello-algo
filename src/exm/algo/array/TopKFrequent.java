package exm.algo.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TopKFrequent {

    public static void main(String[] args) {
        int[] input = new int[]{5,1,-1,-8,-7,8,-5,0,1,10,8,0,-4,3,-1,-1,4,-5,4,-3,0,2,2,2,4,-2,-4,8,-7,-7,2,-8,0,-8,10,8,-8,-2,-9,4,-7,6,6,-1,4,2,8,-3,5,-9,-3,6,-8,-5,5,10,2,-5,-1,-5,1,-3,7,0,8,-2,-3,-1,-5,4,7,-9,0,2,10,4,4,-4,-1,-1,6,-8,-9,-1,9,-9,3,5,1,6,-1,-2,4,2,4,-6,4,4,5,-5};
        System.out.println(Arrays.toString(topKFrequent(input, 7)));
    }

    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.merge(num, 1, Integer::sum);
        }
        int[] tree = new int[k];
        int[] keys = map.keySet().stream().mapToInt(Integer::valueOf).toArray();
        if (keys.length == k) {
            return keys;
        }
        System.arraycopy(keys, 0, tree, 0, k);
        for (int i = k/2 -1; i >= 0; i--) {
            treeify(tree, map, i, k);
        }
        for (int i = k; i < keys.length; i++) {
            if (map.getOrDefault(keys[i], 0) > map.getOrDefault(tree[0], 0)) {
                tree[0] = keys[i];
                treeify(tree, map, 0, k);
            }
        }
        return tree;
    }

    public static void treeify(int[] arr, Map<Integer, Integer> map, int start, int len) {
        int temp = arr[start];
        for (int i = start * 2 + 1; i < len; i = i * 2 + 1) {
            if (i + 1 < len && map.getOrDefault(arr[i+1],0) < map.getOrDefault(arr[i], 0)) {
                i++;
            }
            if (map.getOrDefault(arr[i], 0) < map.getOrDefault(temp, 0)) {
                arr[start] = arr[i];
                start = i;
            } else {
                break;
            }
        }
        arr[start] = temp;
    }
}
