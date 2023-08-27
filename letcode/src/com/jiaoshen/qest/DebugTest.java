package com.jiaoshen.qest;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author jiaoshen
 * @date 2021/12/26-23:11
 */
public class DebugTest {
    public static void main(String[] args) {
        List<Integer>  testlist =  Arrays.asList(9,5,3,10,1);
        List l2 =  testlist.stream().map(item->item =item+1).sorted(Integer::compareTo).collect(Collectors.toList());
        System.out.println(l2);
        LinkedList<Integer> list = new LinkedList<>();
        //
        // list.peekFirst()

    }
}
