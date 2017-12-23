package com.zzq.demo.charpter8;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 二叉树遍历
 * Created by yhsyzzq on 2017-12-23.
 */
public class BinaryTreeTraversal {

    private static List<Integer> dataList = new ArrayList<Integer>();

    /**
     * 根节点
     */
    private static BinaryTreeNode root;

    /**
     * 随机生成0-100的随机数（不包含边界）
     *
     * @return
     */
    private static int nextInt() {
        int data = new Random().nextInt(100);
        if (data == 0 || dataList.contains(data)) {
            return nextInt();
        } else {
            dataList.add(data);
            return data;
        }
    }

    /**
     * 初始化
     */
    public static void init() {
        root = new BinaryTreeNode(nextInt());
        for (int i = 0; i < 50; i++) {
            buildTree(root, nextInt());
        }
    }

    /**
     * 构建二叉树
     */
    public static void buildTree(BinaryTreeNode node, int data) {
        if (root == null) {
            root = new BinaryTreeNode(data);
        } else {
            if (data < node.getData()) {
                if (node.getLeftChild() == null) {
                    node.setLeftChild(new BinaryTreeNode(data));
                    System.out.println(node.getData() + " L=> " + data);
                } else {
                    buildTree(node.getLeftChild(), data);
                }
            } else {
                if (node.getRightChild() == null) {
                    node.setRightChild(new BinaryTreeNode(data));
                    System.out.println(node.getData() + " R=> " + data);
                } else {
                    buildTree(node.getRightChild(), data);
                }
            }
        }
    }

    /**
     * 前序遍历
     */
    public static void preOrderTravel(BinaryTreeNode node) {
        if (node == null) return;
        System.out.print(node.getData() + ", ");
        preOrderTravel(node.getLeftChild());
        preOrderTravel(node.getRightChild());


    }

    /**
     * 中序遍历
     */
    public static void inOrderTravel(BinaryTreeNode node) {
        if (node == null) return;
        inOrderTravel(node.getLeftChild());
        System.out.print(node.getData() + ", ");
        inOrderTravel(node.getRightChild());
    }

    /**
     * 后序遍历
     */
    public static void postOrderTravel(BinaryTreeNode node) {
        if (node == null) return;
        postOrderTravel(node.getLeftChild());
        postOrderTravel(node.getRightChild());
        System.out.print(node.getData() + ", ");
    }

    public static void main(String[] args) {
        System.out.println("构建二叉树*****************");
        BinaryTreeTraversal.init();
        System.out.println("\r\n二叉树前序遍历*************");
        BinaryTreeTraversal.preOrderTravel(root);
        System.out.println("\r\n二叉树中序遍历*************");
        BinaryTreeTraversal.inOrderTravel(root);
        System.out.println("\r\n二叉树后序遍历*************");
        BinaryTreeTraversal.postOrderTravel(root);

    }
}
