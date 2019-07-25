package com.xyz.java.base.collection;

/**
 * @author Administrator
 * @data 2019/7/25
 * @description 二叉树遍历
 */
public class TreeTraverse {


    /**
     * 先序遍历（根左右）
     * @param ele
     */
    public void preOrderTraverse(MyTree ele)
    {
        if (ele == null) {
            return;
        }
        System.out.println(ele.data);
        // 先遍历左
        preOrderTraverse(ele.left);
        // 再遍历右
        preOrderTraverse(ele.right);
    }


    /**
     * 中序遍历（左根右）
     * @param ele
     */
    public void inOrderTraverse(MyTree ele)
    {
        if (ele == null) {
            return;
        }
        // 先遍历左
        inOrderTraverse(ele.left);

        System.out.println(ele.data);

        // 再遍历右
        inOrderTraverse(ele.right);
    }


    /**
     * 后序遍历（左右根）
     * @param ele
     */
    public void postOrderTraverse(MyTree ele)
    {
        if (ele == null) {
            return;
        }

        // 先遍历左
        postOrderTraverse(ele.left);
        // 再遍历右
        postOrderTraverse(ele.right);

        System.out.println(ele.data);
    }


}
