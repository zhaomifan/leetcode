package com.learningjava.tree;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static List<Node> list = new ArrayList<Node>();      //用一个集合来存放每一个Node
    public static void createTree(int[] array) {
        for (int value : array) {
            Node node = new Node(value, null, null);    //创建结点，每一个结点的左结点和右结点为null
            list.add(node); // list中存着每一个结点
        }
        // 构建二叉树
        if (list.size() > 0) {
            for (int i = 0; i < array.length / 2 - 1; i++) {       // i表示的是根节点的索引，从0开始
                if (list.get(2 * i + 1) != null) {
                    // 左结点
                    list.get(i).left = list.get(2 * i + 1);
                }
                if (list.get(2 * i + 2) != null) {
                    // 右结点
                    list.get(i).right = list.get(2 * i + 2);
                }
            }
            // 判断最后一个根结点：因为最后一个根结点可能没有右结点，所以单独拿出来处理
            int lastIndex = array.length / 2 - 1;
            // 左结点
            list.get(lastIndex).left = list.get(lastIndex * 2 + 1);
            // 右结点，如果数组的长度为奇数才有右结点
            if (array.length % 2 == 1) {
                list.get(lastIndex).right = list.get(lastIndex * 2 + 2);
            }
        }
    }

    // 遍历，先序遍历
    public static void print(Node node) {
        if (node != null) {
            System.out.print(node.data + " ");
            print(node.left);
            print(node.right);
        }
    }

    public static void main(String[] args) {
        int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        createTree(array);
        print(list.get(0));
    }
}

class Node {
    public int data;      //自己本身值
    public Node left;     //左结点
    public Node right;     //右结点
    public Node() {
    }
    public Node(int data, Node left, Node right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
    public int getData() {
        return data;
    }
    public void setData(int data) {
        this.data = data;
    }
    public Node getLeft() {
        return left;
    }
    public void setLeft(Node left) {
        this.left = left;
    }
    public Node getRight() {
        return right;
    }
    public void setRight(Node right) {
        this.right = right;
    }
}