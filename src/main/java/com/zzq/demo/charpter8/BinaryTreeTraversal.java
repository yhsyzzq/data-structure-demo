package com.zzq.demo.charpter8;

import org.apache.commons.lang3.StringUtils;

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
        for (int i = 0; i < 10; i++) {
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
     * 构建平衡二叉树
     * 参考链接：http://blog.csdn.net/junwei_yu/article/details/38709889
     * @param node
     * @param data
     */
    public static void buildAVLTree(BinaryTreeNode node, int data){

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

    /**
     * 查找二叉树
     *
     * @param node
     * @param key
     * @return
     */
    public static BinaryTreeNode searchData(BinaryTreeNode node, int key) {
        if (node == null) return null;
        if (key == node.getData()) {
            return node; //查找成功
        } else if (key < node.getData()) {
            return searchData(node.getLeftChild(), key);
        } else {
            return searchData(node.getRightChild(), key);
        }
    }

    /**
     * 插入节点
     *
     * @return
     */
    public static boolean insertNode(BinaryTreeNode node, int key) {
        if (searchData(node, key) == null) {
            if (key < node.getData()) {
                if (node.getLeftChild() == null) {
                    node.setLeftChild(new BinaryTreeNode(key));
                    System.out.println("\r\n插入成功！");
                    return true;
                } else {
                    return insertNode(node.getLeftChild(), key);
                }
            } else if (key > node.getData()) {
                if (node.getRightChild() == null) {
                    node.setRightChild(new BinaryTreeNode(key));
                    return true;
                } else {
                    return insertNode(node.getRightChild(), key);
                }
            }
        } else {
            System.out.println("值" + key + "已存在，不可重复插入！");
            return false;
        }
        return false;
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

        //循环查找50-59的值
        for (int i = 50; i < 60; i++) {
            BinaryTreeNode node = searchData(root, i);
            if (node != null) {
                System.out.println("\r\n查找节点成功，节点值为：" + node.getData());
            }
        }

        //循环插入值
        int count = 0;
        int[] insertArray = new int[20];
        for (int i = 1; i < 10; i++) {
            if (insertNode(root, i)) {
                insertArray[count++] = i;
            }
        }
        System.out.println("共成功插入" + count + "个元素，分别为：" + StringUtils.join(insertArray, ',', 0, count));
        System.out.println("\r\n插入数据后二叉树中序遍历*************");
        BinaryTreeTraversal.inOrderTravel(root);

    }
}
