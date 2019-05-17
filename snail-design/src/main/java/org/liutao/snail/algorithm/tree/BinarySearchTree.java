package org.liutao.snail.algorithm.tree;

import java.util.Random;

public class BinarySearchTree {
    private static int getRandomNumberInRange(int min, int max) {
        Random r = new Random();
        return r.ints(min, (max + 1)).findFirst().getAsInt();
    }


    public static void main(String[] args) {
        int length = 10;
        TreeNde root = new TreeNde(50);
//        BinarySearchTree.insert(15, root);
//        BinarySearchTree.insert(65, root);
//        BinarySearchTree.insert(12, root);
//        BinarySearchTree.insert(67, root);
//        BinarySearchTree.insert(20, root);
//        BinarySearchTree.insert(2, root);
//        BinarySearchTree.insert(78, root);
//        BinarySearchTree.insert(90, root);
//        BinarySearchTree.insert(3, root);
        root.insertNode(15).insertNode(65).insertNode(12).insertNode(61).insertNode(67).
                insertNode(20).insertNode(2).insertNode(64).insertNode(78).insertNode(90).insertNode(3);
        TreeUtils.printTree(root);

        System.out.println("\n前序遍历");
        TreeUtils.preOrder(root);
        System.out.println("\n中序遍历");
        TreeUtils.inOrder(root);
        TreeNde findTree = BinarySearchTree.find(78, root);
        System.out.println("");
        System.out.println(findTree != null ? findTree.getVal() : "没找到节点");

        TreeNde max = BinarySearchTree.findMax(root);
        System.out.println("");
        System.out.println(max != null ? max.getVal() : "没找到节点");

        TreeNde min = BinarySearchTree.findMin(root);
        System.out.println("");
        System.out.println(min != null ? min.getVal() : "没找到节点");

        System.out.println("");
        root.deleteNode(67);
        TreeUtils.printTree(root);
        TreeUtils.inOrder(root);
        System.out.println("");
        System.out.println("根据前序遍历和中序遍历重建二叉搜素树");
        int preorder[] = {1, 2, 4, 7, 3, 5, 6, 8};
        int inorder[] = {4, 7, 2, 1, 5, 3, 8, 6};
        int postorder[] = {7, 4, 2, 5, 8, 6, 3, 1};
        TreeNde rebuildTree = rebuildBinaryTreeCore(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
        TreeUtils.inOrder(rebuildTree);
        System.out.println("");
        TreeUtils.postOrder(rebuildTree);
    }

    public static TreeNde insertNode(int data, TreeNde root) {
        TreeNde newNode = new TreeNde(data);
        if (root == null) {
            return newNode;
        }

        TreeNde temp = root;

        while (temp != null) {
            if (temp.getVal() > data) {
                if (temp.getLeft() == null) {
                    temp.setLeft(newNode);
                    return root;
                } else {
                    temp = temp.getLeft();
                }
            } else {
                if (temp.getRight() == null) {
                    temp.setRight(newNode);
                    return root;
                } else {
                    temp = temp.getRight();
                }
            }
        }

        return null;
    }


    //插入节点
    public static boolean insert(int data, TreeNde root) {
        TreeNde newNode = new TreeNde(data);
        if (root == null) {//当前树为空树，没有任何节点
            root = newNode;
            return true;
        } else {
            TreeNde current = root;
            TreeNde parentNode = null;
            while (current != null) {
                parentNode = current;
                if (current.getVal() > data) {//当前值比插入值大，搜索左子节点
                    current = current.getLeft();
                    if (current == null) {//左子节点为空，直接将新值插入到该节点
                        parentNode.setLeft(newNode);
                        return true;
                    }
                } else {
                    current = current.getRight();
                    if (current == null) {//右子节点为空，直接将新值插入到该节点
                        parentNode.setRight(newNode);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    //查找节点
//    public static TreeNde find(int key, TreeNde root) {
//        TreeNde current = root;
//        while (current != null) {
//            if (current.getVal() > key) {//当前值比查找值大，搜索左子树
//                current = current.getLeft();
//            } else if (current.getVal() < key) {//当前值比查找值小，搜索右子树
//                current = current.getRight();
//            } else {
//                return current;
//            }
//        }
//        return null;//遍历完整个树没找到，返回null
//    }

    /**
     * 求最大值
     *
     * @param root
     * @return
     */
    public static TreeNde findMax(TreeNde root) {
        if (root == null) return null;
        TreeNde temp = root.getRight();
        while (temp.getRight() != null) {
            temp = temp.getRight();
        }
        return temp;
    }

    /**
     * 最小值
     *
     * @param root
     * @return
     */
    private static TreeNde findMin(TreeNde root) {
        if (root == null) return null;
        TreeNde temp = root.getLeft();
        while (temp.getLeft() != null) {
            temp = temp.getLeft();
        }
        return temp;
    }

    public static TreeNde find(int key, TreeNde root) {
        if (root == null) return null;
        TreeNde temp = root;
        while (temp != null) {
            if (key > temp.getVal()) {
                temp = temp.getRight();
            } else if (key < temp.getVal()) {
                temp = temp.getLeft();
            } else {
                return temp;
            }
        }
        return null;
    }


    /**
     * 根据前序遍历和中序遍历重建二叉搜索树
     *  参考地址<a herf='https://blog.csdn.net/u013132035/article/details/80519895'>https://blog.csdn.net/u013132035/article/details/80519895</a>
     * @param preorder      前序遍历
     * @param startPreorder 前序起始位置
     * @param endPreorder   前序长度
     * @param inorder       中序遍历
     * @param startInorder  中序起始位置
     * @param endInorder    中序长度
     * @return {1, 2, 4, 7, 3, 5, 6, 8};
     * {4, 7, 2, 1, 5, 3, 8, 6};
     */
    public static TreeNde rebuildBinaryTreeCore(int[] preorder, int startPreorder, int endPreorder, int[] inorder, int startInorder, int endInorder) {

        if (startPreorder > endPreorder || startInorder > endInorder) { //停止递归的条件
            return null;
        }
        TreeNde root = new TreeNde(preorder[startPreorder]);//前序遍历的第0位，也就是跟节点

        for (int i = startInorder; i <= endInorder; i++) {
            if (preorder[startPreorder] == inorder[i]) {
                // 其中（i - startInorder）为中序排序中左子树结点的个数
                //左子树
                root.setLeft(rebuildBinaryTreeCore(preorder, startPreorder + 1, startPreorder + (i - startInorder), inorder, startInorder, i - 1));
                //右子树
                root.setRight(rebuildBinaryTreeCore(preorder, (i - startInorder) + startPreorder + 1, endPreorder, inorder, i + 1, endInorder));
            }
        }
        return root;
    }
}