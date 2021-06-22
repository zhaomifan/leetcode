package com.newcode;

import java.util.Scanner;
import java.util.TreeSet;

public class Paixv {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int numLength=scanner.nextInt();
            TreeSet<Integer> treeSet = new TreeSet<>();
            for (int i = 0; i < numLength; i++) {
                treeSet.add(scanner.nextInt());
            }
            for (int node:treeSet
                 ) {
                System.out.println(node);
            }
        }
    }
}
