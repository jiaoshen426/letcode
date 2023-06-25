package com.jiaoshen.study.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 打印一个字符串的全部排列
 * 打印一个字符串的全部排列，要求不要出现重复的排列
 * @author jiaoshen
 * @date 2023-06-17-21:06
 */
public class PrintAllPermutations {
    public static void main(String[] args) {
        String str = "abc";
        queryPermutation(str);
    }

    public static List<String> queryPermutation(String str) {
        List<String> result = new ArrayList<>();
        List<Character> left = str.chars().mapToObj(c -> (char) c).collect(Collectors.toList());

       // process1(left,  "", result);
        process2(str.toCharArray(),  0, result);
        result.stream().forEach(System.out::println);
        return result;

    }

    /**
     * 每个位置在剩余的集合里面取值
     * @param arrays
     * @param path
     * @param result
     */
    public static void process1( List<Character> arrays,  String path, List<String> result) {
        if(arrays.size() == 1){
            result.add(path+arrays.get(0));
            return;
        }
        Integer length = arrays.size();
        for (int i = 0; i <length; i++) {
            Character cur = arrays.get(i);
            arrays.remove(i);
            process1(arrays,  path+cur,result);
            arrays.add(i,cur);
        }
    }

    public static void process2( char[] arrays, int index, List<String> result) {
        if(index == arrays.length){
            result.add(String.valueOf(arrays));
            return;
        }
        for (int i = index; i <arrays.length; i++) {
            swap(arrays,i,index);
            process2(arrays,index+1,result);
            swap(arrays,i,index);
        }
    }

    public static void swap(char[] chs, int i, int j) {
        char tmp = chs[i];
        chs[i] = chs[j];
        chs[j] = tmp;
    }
}
