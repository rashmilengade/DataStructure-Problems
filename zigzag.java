package com.example;

public class zigzag {
        static class node
        {
            node left;
            node right;
            int data;
        }
        static node newNode (int data)
        {
            node temp = new node();
            temp.data=data;
            temp.left=null;
            temp.right=null;
            return temp;
        }
        static int heightOfTree(node root)
        {
            if(root == null)
                return 0;
            int leftHeight = heightOfTree(root.left);
            int rightHeight = heightOfTree(root.right);

            return Math.max(leftHeight+1,rightHeight+1);
        }
        static void printLeftToRight(node root, int level)
        {
            if(root == null)
                return;

            if(level == 1)
                System.out.print(root.data + " ");

            else if (level > 1)
            {
                printLeftToRight(root.left , level - 1);
                printLeftToRight(root.right , level - 1);
            }
        }

    static void printRightToLeft(node root, int level)
    {
        if(root == null)
            return;

        if(level == 1)
            System.out.print(root.data + " ");

        else if (level > 1)
        {
            printRightToLeft(root.right, level - 1);
            printRightToLeft(root.left, level - 1);
        }
    }

    static void printZigZag(node root)
    {
        int flag=0;
        int height=heightOfTree(root);
        System.out.println(height);
        for (int i=1; i<=height; i++)
        {
            if(flag == 0)
            {
                printLeftToRight(root, i);
                flag = 1;
            }
            else if(flag == 1)
            {
                printRightToLeft(root, i);
                flag = 0;
            }
        }
    }

        public static void main(String[] args) {
            node root = newNode(7);
            root.left = newNode(4);
            root.right = newNode(5);
            root.left.left = newNode(9);
            root.right.right = newNode(10);
            root.left.left.left = newNode(6);
            root.left.left.right = newNode(11);

            printZigZag(root);
        }
}
