package org.liutao.snail.algorithm.tree;

public class InitTree {
    public static void main(String[] args) {
        TreeNde root = new TreeNde(0);
        TreeNde treeNde1 = new TreeNde(1);
        TreeNde treeNde2 = new TreeNde(2);
        TreeNde treeNde3 = new TreeNde(3);
        TreeNde treeNde4 = new TreeNde(4);
        TreeNde treeNde5 = new TreeNde(5);
        TreeNde treeNde6 = new TreeNde(6);
        TreeNde treeNde7 = new TreeNde(7);
        TreeNde treeNde8 = new TreeNde(8);
        TreeNde treeNde9 = new TreeNde(9);

        root.setLeft(treeNde1);
        root.setRight(treeNde2);

        treeNde1.setLeft(treeNde3);
        treeNde1.setRight(treeNde4);
        treeNde2.setLeft(treeNde5);
        treeNde2.setRight(treeNde6);

        treeNde3.setLeft(treeNde7);
        treeNde3.setRight(treeNde8);
        treeNde4.setLeft(treeNde9);
        System.out.println("前序遍历");
        preOrder(root);
        System.out.println("\n中序遍历");
        inOrder(root);
        System.out.println("\n后序遍历");
        postOrder(root);
        System.out.println("\n最大深度");
        int high = maxDeath(root);
        System.out.println(high);
    }


    public static int maxDeath(TreeNde node){
        if(node==null){
            return 0;
        }
        int left = maxDeath(node.getLeft());
        int right = maxDeath(node.getRight());
        return Math.max(left,right) + 1;
    }

    /**
     * 前序遍历
     *
     * @param root
     */
    public static void preOrder(TreeNde root) {
        if (root == null) {        //树为空的情况
            return;
        }
        System.out.print(root.getVal() + "  >");    //先遍历树根
        preOrder(root.getLeft());    //再前序遍历左子树
        preOrder(root.getRight());    //再前序遍历右子树
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
}