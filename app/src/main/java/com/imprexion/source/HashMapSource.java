package com.imprexion.source;

import android.util.SparseArray;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.ListIterator;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author : gongh
 * @date : 2020/8/5 16:05
 * @desc : TODO
 */
class HashMapSource {

    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("hahh", "helloWord");
        map.put("hahh", "helloWord");
        map.put("hahh", "helloWord");
        map.put("hahh", "helloWord");
        map.put("hahh", "helloWord");
        map.put("hahh", "helloWord");
        map.put("hahh", "helloWord");
        map.put("hahh", "helloWord");
        map.put("hahh", "helloWord");
        map.put("hahh", "helloWord");
        map.put("hahh", "helloWord");
        map.put("hahh", "helloWord");
        map.put("hahh", "helloWord");
        map.put("hahh", "helloWord");
        map.put("hahh", "helloWord");
        map.put("hahh", "helloWord");
        map.put("hahh", "helloWord");
        map.put("hahh", "helloWord");
        map.put("hahh", "helloWord");
        map.put("hahh", "helloWord");

        String value = map.get("hahh");


        HashSet<String> strings = new HashSet<>();
        strings.add("value");

        for (String next : strings) {
            System.out.println(next);
        }

        ArrayList<String> strings1 = new ArrayList<>();
        strings.add("a");
        strings.add("b");
        strings.add("c");
        ListIterator<String> stringListIterator = strings1.listIterator();


        SparseArray<String> stringSparseArray = new SparseArray<>();

        ConcurrentHashMap<String, String> strConCurrentHashMap = new ConcurrentHashMap<>();
        strConCurrentHashMap.put("hha" ,"fuck");
        strConCurrentHashMap.get("hha");


    }
}
