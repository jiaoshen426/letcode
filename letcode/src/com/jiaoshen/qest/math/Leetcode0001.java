package com.jiaoshen.qest.math;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Leetcode0001 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum2(new int[]{3,3},6)));

    }
    public static int[] twoSum1(int[] nums, int target) {
        for (int i = 0; i < nums.length-1; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if(nums[i] +nums[j] == target){
                    return  new int[]{i,j};

                }
            }
        }
        return null;
    }

    public static int[] twoSum2(int[] nums, int target) {

        List<Integer> numbers = Arrays.stream(nums).boxed().collect(Collectors.toList());
        for (int i = 0; i < nums.length-1; i++) {
            int j=numbers.lastIndexOf(target-nums[i]);
            if(j >-1 && i!=j){
                return  new int[]{i,j};
            }

        }
        return null;
    }
    
}
