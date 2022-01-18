package com.jiaoshen.qest.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 20. 有效的括号
 */
public class Leetcode0020 {




    public boolean isValid(String s) {
        List<String> myStack = new ArrayList<>();
        char[] schar = s.toCharArray();
        for(int i=0;i<schar.length;i++){
            if(Arrays.asList('(','{','[').indexOf(schar[i])>-1){
                myStack.add(s);
            }else if(')' == schar[i] ){

                //myStack.remove()
            }

        }

        return true;
    }


    public static void main(String[] args) {


    }


    
}
