package org.liutao.snail.algorithm.tree;

import java.util.ArrayList;
import java.util.List;

public class TreeNde {
    private int val;

    public TreeNde(int val) {
        this.val = val;
    }

    /**
     * 左
     */
    private TreeNde left;

    /**
     * 右
     */
    private TreeNde right;

    public int getVal() {
        return val;
    }

    public TreeNde getLeft() {
        return left;
    }

    public void setLeft(TreeNde left) {
        this.left = left;
    }

    public TreeNde getRight() {
        return right;
    }

    public void setRight(TreeNde right) {
        this.right = right;
    }

    public TreeNde insertNode(int data) {
        TreeNde newNode = new TreeNde(data);
        TreeNde temp = this;

        while (temp != null) {
            if (temp.getVal() > data) {
                if (temp.getLeft() == null) {
                    temp.setLeft(newNode);
                    return this;
                } else {
                    temp = temp.getLeft();
                }
            } else {
                if (temp.getRight() == null) {
                    temp.setRight(newNode);
                    return this;
                } else {
                    temp = temp.getRight();
                }
            }
        }
        return this;
    }

    /**
     * 参考 https://blog.csdn.net/isea533/article/details/80345507
     * @param data
     * @return
     */
    public TreeNde deleteNode(int data) {

        TreeNde parentNode = this;
        TreeNde deleteNode = this;

        while (deleteNode != null && deleteNode.getVal() != data) {
            parentNode = deleteNode;
            if (deleteNode.getVal() > data) {
                deleteNode = parentNode.getLeft();
            } else {
                deleteNode = parentNode.getRight();
            }
        }
        if (deleteNode == null) {
            System.out.println("删除功能   未找到节点");
        } else {
            System.out.println("父节点    " + parentNode.getVal() + "删除节点  " + deleteNode.getVal());
        }
        //被删除节点为叶子节点
        if (deleteNode.getRight() == null && deleteNode.getLeft() == null) {
            if (parentNode.getVal() > data) {
                parentNode.setLeft(null);
            } else {
                parentNode.setRight(null);
            }
        } else if (deleteNode.getRight() != null && deleteNode.getLeft() != null) {//同时存在左右子节点
            TreeNde leftChildNode = deleteNode.getLeft();
            TreeNde rightChildNode = deleteNode.getRight();
            if (parentNode.getVal() > data) {
                parentNode.setLeft(null);
            } else {
                parentNode.setRight(null);
            }
            List<TreeNde> list =new  ArrayList<TreeNde>();
            TreeUtils.preOrder(leftChildNode,list);
            System.out.println("");
            TreeUtils.preOrder(rightChildNode,list);
            for(TreeNde temp : list){
                parentNode.insertNode(temp.getVal());
            }
        } else if (deleteNode.getRight() != null || deleteNode.getLeft() != null) {//存在左节点或者右节点，删除后需要对子节点移动
            TreeNde childNode = deleteNode.getLeft() == null ? deleteNode.getRight() : deleteNode.getLeft();
            if (parentNode.getVal() > data) {
                parentNode.setLeft(null);
            } else {
                parentNode.setRight(null);
            }
            List<TreeNde> list =new  ArrayList<TreeNde>();
            TreeUtils.preOrder(childNode,list);
            for(TreeNde temp : list){
                parentNode.insertNode(temp.getVal());
            }
        }

        return this;
    }
}