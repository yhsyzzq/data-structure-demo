package com.zzq.demo.charpter8;

/**
 * 二叉树结点
 * Created by yhsyzzq on 2017-12-23.
 */
public class BinaryTreeNode {

    /**
     * 数据
     */
    private int data;

    /**
     * 左孩节点
     */
    private BinaryTreeNode leftChild;

    /**
     * 右孩节点
     */
    private BinaryTreeNode rightChild;

    public BinaryTreeNode(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public BinaryTreeNode getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(BinaryTreeNode leftChild) {
        this.leftChild = leftChild;
    }

    public BinaryTreeNode getRightChild() {
        return rightChild;
    }

    public void setRightChild(BinaryTreeNode rightChild) {
        this.rightChild = rightChild;
    }

}
