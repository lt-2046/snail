package org.liutao.snail.algorithm.tree;

import java.util.List;

public class TreeUtils {
    /**
     * 前序遍历
     *
     * @param root
     */
    public static void preOrder(TreeNde root) {
        if (root == null) {        //树为空的情况
            return;
        }
        System.out.print(root.getVal() + " > ");    //先遍历树根
        preOrder(root.getLeft());    //再前序遍历左子树
        preOrder(root.getRight());    //再前序遍历右子树
    }
    public static void preOrder(TreeNde root, List<TreeNde> nodeList) {
        if (root == null) {        //树为空的情况
            return;
        }

        nodeList.add(root);
        preOrder(root.getLeft(),nodeList);    //再前序遍历左子树
        preOrder(root.getRight(),nodeList);    //再前序遍历右子树
    }
    /**
     * 中序遍历
     *
     * @param root
     */
    public static void inOrder(TreeNde root) {
        if (root == null) {        //树为空的情况
            return;
        }
        inOrder(root.getLeft());    //再前序遍历左子树
        System.out.print(root.getVal() + "  >");    //先遍历树根
        inOrder(root.getRight());    //再前序遍历右子树
    }

    /**
     * 后序遍历
     *
     * @param root
     */
    public static void postOrder(TreeNde root) {
        if (root == null) {        //树为空的情况
            return;
        }
        postOrder(root.getLeft());    //再前序遍历左子树
        postOrder(root.getRight());    //再前序遍历右子树
        System.out.print(root.getVal() + "  >");    //先遍历树根
    }


    /**
     * 参考 https://blog.csdn.net/u011676300/article/details/80715249
     *
     * @param head
     */
    public static void printTree(TreeNde head) {
        System.out.println("-----------------\r\nBinary Tree:");
        printInOrder(head, 0, "Root-", 8);
        System.out.println();
    }

    private static void printInOrder(TreeNde head, int height, String to, int len) {
        if (head == null) {
            return;
        }
        printInOrder(head.getRight(), height + 1, "R-", len);
        String val = to + head.getVal();
        int lenM = val.length();
        int lenL = (len - lenM) / 2;
        int lenR = len - lenM - lenL;
        val = getSpace(lenL) + val;// + getSpace(lenR);
        System.out.println(getSpace(height * len) + val);
        printInOrder(head.getLeft(), height + 1, "L-", len);
    }

    private static String getSpace(int num) {
        String space = " ";
        StringBuffer buf = new StringBuffer("");
        for (int i = 0; i < num; i++) {
            buf.append(space);
        }
        return buf.toString();
    }
}