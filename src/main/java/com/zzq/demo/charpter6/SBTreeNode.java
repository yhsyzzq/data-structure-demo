package com.zzq.demo.charpter6;

import java.util.Comparator;

/**
 * 二叉树
 * Created by yhsyzzq on 2017-12-12.
 */
public class SBTreeNode {
    /**
     * 节点数据
     */
    private int key;

    /**
     * 左子树节点
     */
    private SBTreeNode left;

    /**
     * 右子树节点
     */
    private SBTreeNode right;

    /**
     * 父节点
     *
     * @return
     */
    private SBTreeNode parent;

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public SBTreeNode getLeft() {
        return left;
    }

    public void setLeft(SBTreeNode left) {
        this.left = left;
    }

    public SBTreeNode getRight() {
        return right;
    }

    public void setRight(SBTreeNode right) {
        this.right = right;
    }
}
