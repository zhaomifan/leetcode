package com.test;

import javax.swing.*;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
// Scanner sc = new Scanner(System.in);
//         while (sc.hasNext()){
//         int next = sc.nextInt();
//         TreeMap<Integer,Integer> map = new TreeMap<>();
//        for (int i = 0; i < next; i++) {
//        int key = sc.nextInt();
//        int value = sc.nextInt();
//        if (map.containsKey(key)){
//        map.put(key,map.get(key)+value);
//        }else {
//        map.put(key,value);
//        }
//        }
//        for (Map.Entry<Integer, Integer> integerIntegerEntry : map.entrySet()) {
//        System.out.println(integerIntegerEntry.getKey()+" "+integerIntegerEntry.getValue());
//        }
//        }


public class Main {
    public static void main(String[] args) {
        String userInfo = "###北京通力互联技术服务有限公司###姓    名:冯磊###性    别:";
        userInfo = userInfo.replaceAll(" ", "");
        Pattern r = Pattern.compile("姓\\s*名:(\\S*)###");
        Matcher m = r.matcher(userInfo);
        if (m.find()) {
            for (int i = 0; i < m.groupCount(); i++) {
                System.out.println(m.group(i));
            }
        } else {
            System.out.println(userInfo);
        }
    }
}