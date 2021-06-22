package com.learningjava;

public class Part04_StringBuffer {
    public static void main(StringPractice[] args) {
        StringBuffer sb = new StringBuffer();
        sb.append("dd");
        sb.append("ss");
        System.out.println(sb);;
        sb.insert(4, "ii");
        System.out.println(sb.reverse());
    }
}
