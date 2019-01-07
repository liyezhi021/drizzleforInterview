package com.example.algorithm.ercha;

public class Tree {

    Node root;

    public Node find(int key){
        Node currentNode = root;
        while(currentNode != null && currentNode.key != key){
            if(key < currentNode.key){
                currentNode = currentNode.leftChild;
            }else{
                currentNode = currentNode.rightChild;
            }
        }
        return currentNode;
    }

    public void insert(int key, int value){

        if(root == null){
            root = new Node(key, value);
            return;
        }
        Node currentNode = root;
        Node parentNode = root;
        boolean isLeftChild = true;
        while(currentNode != null){
            parentNode = currentNode;
            if(key <currentNode.key){
                currentNode = currentNode.leftChild;
                isLeftChild = true;
            }else{
                currentNode = currentNode.rightChild;
                isLeftChild = false;
            }
        }
        Node newNode = new Node(key, value);
        if(isLeftChild) parentNode.leftChild = newNode;
        else parentNode.rightChild = newNode;
    }

    public boolean delete(int key){
        Node currentNode = root;
        Node parentNode = root;
        boolean isLeftChild = true;
        while (currentNode != null && currentNode.key != key) {
            parentNode = currentNode;
            if (key < currentNode.key) {
                currentNode = currentNode.leftChild;
                isLeftChild = true;
            } else {
                currentNode = currentNode.rightChild;
                isLeftChild = false;
            }
        }
        if (currentNode == null) {
            return false;
        }
        if (currentNode.leftChild == null && currentNode.rightChild == null) {
            //要删除的节点为叶子节点
            if (currentNode == root)
                root = null;
            else if (isLeftChild)
                parentNode.leftChild = null;
            else
                parentNode.rightChild = null;
        } else if (currentNode.rightChild == null) {//要删除的节点只有左孩子
            if (currentNode == root)
                root = currentNode.leftChild;
            else if (isLeftChild)
                parentNode.leftChild = currentNode.leftChild;
            else
                parentNode.rightChild = currentNode.leftChild;
        } else if (currentNode.leftChild == null) {//要删除的节点只有右孩子
            if (currentNode == root)
                root = currentNode.rightChild;
            else if (isLeftChild)
                parentNode.leftChild = currentNode.rightChild;
            else
                parentNode.rightChild = currentNode.rightChild;
        } else { //要删除的节点既有左孩子又有右孩子
            //思路：用待删除节点右子树中的key值最小节点的值来替代要删除的节点的值,然后删除右子树中key值最小的节点
            //右子树key最小的节点一定不含左子树,所以删除这个key最小的节点一定是属于叶子节点或者只有右子树的节点
            Node directPostNode = getDirectPostNode(currentNode);
            currentNode.key = directPostNode.key;
            currentNode.value = directPostNode.value;
        }
        return true;
    }

    private Node getDirectPostNode(Node delNode){ //获得删除节点的直接后继节点
        Node parentNode = delNode;//用来保存待删除节点的直接后继节点的父亲节点
        Node directPostNode = delNode;//用来保存待删除节点的直接后继节点
        Node currentNode = delNode.rightChild;
        while (currentNode != null) {
            parentNode = directPostNode;
            directPostNode = currentNode;
            currentNode = currentNode.leftChild;
        }
        if (directPostNode != delNode.rightChild) {//从树中删除此直接后继节点
            parentNode.leftChild = directPostNode.rightChild;
            directPostNode.rightChild = null;
        }
        return directPostNode;//返回此直接后继节点
    }

    public void preOrder(Node rootNode){
        if(rootNode!= null){
            System.out.println(rootNode.key + " " + rootNode.value);
            preOrder(rootNode.leftChild);
            preOrder(rootNode.rightChild);
        }
    }

    public void inOrder(Node rootNode){
        if (rootNode != null) {
            inOrder(rootNode.leftChild);
            System.out.println(rootNode.key + " " + rootNode.value);
            inOrder(rootNode.rightChild);
        }
    }

    public void postOrder(Node rootNode){
        if (rootNode != null) {
            postOrder(rootNode.leftChild);
            postOrder(rootNode.rightChild);
            System.out.println(rootNode.key + " " + rootNode.value);
        }
    }

}
