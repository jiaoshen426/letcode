package com.jiaoshen.study.recursion;

import java.time.chrono.MinguoChronology;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个字符串str，给定一个字符串类型的数组arr，出现的字符都是小写英文
 * arr每一个字符串，代表一张贴纸，你可以把单个字符剪开使用，目的是拼出str来
 * 返回需要至少多少张贴纸可以完成这个任务
 * 例子：str= "babac"，arr = {"ba","c","abcd"}
 * ba + ba + c  3  abcd + abcd 2  abcd+ba 2
 * https://leetcode.cn/problems/stickers-to-spell-word/
 *
 * @author jiaoshen
 * @date 2023-07-15-14:18
 */
public class StickersToSpellWord {

    public static void main(String[] args) {
//        ["control","heart","interest","stream","sentence","soil","wonder","them","month","slip","table","miss","boat","speak","figure","no","perhaps","twenty","throw","rich","capital","save","method","store","meant","life","oil","string","song","food","am","who","fat","if","put","path","come","grow","box","great","word","object","stead","common","fresh","the","operate","where","road","mean"]
//        "stoodcrease"

        String[] stickers = {"bring","plane","should","against","chick"};
        String target = "greatscore";
        System.out.println(minStickers(stickers, target));

    }


    public static int minStickers(String[] stickers, String target) {
        Map<String,Integer> cacheMap = new HashMap<>();
        int result=  process(stickers, target,cacheMap);
        if(result == Integer.MAX_VALUE){
            return -1;
        }
        return  result;
    }

    private static int process(String[] stickers, String target, Map<String,Integer> cacheMap) {
        if(cacheMap.containsKey(target)){
            return cacheMap.get(target);
        }
        int min = Integer.MAX_VALUE;
        if (target.length() == 0) {
            return 0;
        }
        for (String first : stickers) {
            String rest = minus(first, target);
            if (rest.length() != target.length()) {
                min = Math.min(min, process(stickers, rest,cacheMap));
            }
        }
        int result = min ==Integer.MAX_VALUE? Integer.MAX_VALUE: min + 1;
        cacheMap.put(target,result);
        return result;
    }

    public static String minus(String indexStr, String target) {
        char[] indexArray = indexStr.toCharArray();
        char[] targetArray = target.toCharArray();
        int[] count = new int[26];
        for (char c : indexArray) {
            count[c - 'a']--;
        }
        for (char c : targetArray) {
            count[c - 'a']++;
        }
        String result = "";
        for (int i = 0; i < count.length; i++) {
            if (count[i] > 0) {
                for (int i1 = count[i]; i1 > 0; i1--) {
                    result += (char) ('a' + i);
                }
            }
        }
        return result;
    }


}
