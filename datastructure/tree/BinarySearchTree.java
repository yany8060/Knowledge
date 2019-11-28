package datastructure.tree;

/**
 * 二叉扫搜树
 */
public class BinarySearchTree {

    private Node tree;

    /**
     * 查找
     * @param data
     * @return
     */
    public Node find(int data) {
        Node p = tree;
        while(p != null) {
            if(p.data > data) {
                p = p.left;
            } else if (p.data < data) {
                p = p.right;
            } else {
                return p;
            }
        }
        return null;
    }

    /**
     * 插入
     * 
     */
    public void insert(int data) {
        if(tree == null) {
            tree = new Node(data);
            return;
        }
        Node p = tree;
        while(p != null) {
            if(p.data > data) {
                if(p.left == null) {
                    p.left = new Node(data);
                    return;
                }
                p = p.left;
            } else {
                if(p.right == null) {
                    p.right = new Node(data);
                    return;
                }
                p = p.right;
            }
        }
    }


    /**
     * 删除节点
     * 1. 查询要删除的节点p及其父节点pp
     * 2. 删除节点p存在左右子树，查询右（左）子树最小（大）的节点替换删除节点p，最后删除替换节点
     * 3. 删除节点p只存在左子树，p节点子节点覆盖p节点
     * 4. 删除节点p只存在右子树，p节点子节点覆盖p节点
     * @param data
     */
    public void delete(int data) {
        Node p = tree;
        Node pp = null; // pp记录的是p的父节点
        while (p != null && p.data != data) {
            pp = p;
            if(data > p.data) {
                p = p.right;
            } else {
                p = p.left;
            }
        }
        if(p == null) return;

        // 要删除的节点有两个子节点
        if(p.left != null && p.right != null) {
            Node minP = p.right;
            Node minPP = p;
            while(minP.left != null) {
                minPP = minP;
                minP = minP.left;
            }
            p.data = minP.data;
            // minP = null;
            // return;
            p = minP;
            pp = minPP;
        }

        // 删除节点是叶子节点或者仅有一个子节点
        Node child; // p的子节点
        if (p.left != null) child = p.left;
        else if(p.right != null) child = p.right;
        else child = null;

        if(pp == null) {
            tree = child; // 删除的是根节点
        } else if(pp.left == p) {
            pp.left = child;
        } else {
            pp.right = child;
        }
    }

    public Node findMin() {
        if(tree == null) return null;
        Node p = tree;
        while(p.left != null) {
            p = p.left;
        }
        return p;
    }

    public Node findMax() {
        if (tree == null) return null;
        Node p = tree;
        while (p.right != null) {
          p = p.right;
        }
        return p;
      }

    public static class Node {
        private int data;
        private Node left;
        private Node right;

        public Node(int data) {
            this.data = data;
        }
    }

}