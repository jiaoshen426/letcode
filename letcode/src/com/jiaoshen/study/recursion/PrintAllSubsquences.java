package com.jiaoshen.study.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * 打印一个字符串的全部子序列(不用连续)
 * 打印一个字符串的全部子序列，要求不要出现重复字面值的子序列
 *
 * @author jiaoshen
 * @date 2023-06-17-10:52
 */
public class PrintAllSubsquences {

    public static void main(String[] args) {
        String str = "abc";
        querySubsquences(str);
    }

    public static List<String> querySubsquences(String str) {
        char[] arrays = str.toCharArray();
        List<String> result = new ArrayList<>();
        process1(arrays, 0, "", result);
        result.stream().forEach(System.out::println);
        return result;

    }

    /**
     * 遍历每个位置有和没有
     * @param arrays
     * @param index
     * @param path
     * @param result
     */
    public static void process1(char[] arrays, int index, String path, List<String> result) {
        if(index == arrays.length){
            result.add(path);
            return;
        }
        process1(arrays,index+1,path,result);
        process1(arrays,index+1,path+arrays[index] ,result);

    }


}
