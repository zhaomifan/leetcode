package com.learningjava;

public class StringPractice {
    public static void main(String[] args) {
//        String str = "hello";
//        str=str.substring(1);
//        System.out.println(str);
//        str = str.concat("9999");
//        System.out.println(str);
//        System.out.println(str.indexOf("llo"));
//        char[] res = {99,99,99,99,99,99};
//        str.getChars(1,1,res,3);
//        System.out.println(res);
        StringBuffer buffer = new StringBuffer("aaaaaaaaaaaa");
//        System.out.println(buffer.insert(2, "dsd"));
        System.out.println(buffer.replace(2,1,"i"));
        new StringBuilder();
    }
}
