package com.jiaoshen;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jiaoshen
 * @date 2022/2/3-23:37
 */
public class VideoTest {
    public static void main(String[] args) {
        Multimap<String,Object> myMultimap = ArrayListMultimap.create();
        Map<String, List<String>> map = new HashMap<>();
        map.computeIfAbsent("123",k->new ArrayList<String>());
        map.get("123").add("jiaoshen");
        System.out.println(map);

    }
}
