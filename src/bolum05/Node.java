package bolum05;

public class Node {
    int data;
    Node left;
    Node right;
    
    public Node(int data) {
        this.data = data;
    }
    
    Node getMaxIterative() {
        Node result = this;
        while (result.right != null) {
            result = result.right;
        }
        return result;
    }
    
    Node getMinIterative() {
        Node result = this;
        while (result.left != null) {
            result = result.left;
        }
        return result;
    }
    
    Node getMaxRecursive() {
        if (right == null)
            return this;
        return right.getMaxRecursive();
    }
    
    Node getMinRecursive() {
        if (left == null)
            return this;
        return left.getMinRecursive();
    }
    
    Node searchRecursive(int x) {
        if (data == x)
            return this;
        if (x < data) {
            if (left != null) {
                return left.searchRecursive(x);
            } else {
                return null;
            }
        } else {
            if (right != null) {
                return right.searchRecursive(x);
            } else {
                return null;
            }
        }
    }
    
    void printInOrder() {
        System.out.print(data + " ");
        if (left != null)
            left.printInOrder();
        if (right != null)
            right.printInOrder();
    }
    
    void printPreOrder() {
        if (left != null)
            left.printPreOrder();
        System.out.print(data + " ");
        if (right != null)
            right.printPreOrder();
    }
    
    void printPostOrder() {
        if (left != null)
            left.printPostOrder();
        if (right != null)
            right.printPostOrder();
        System.out.print(data + " ");
    }
    
    public static void main(String[] args) {
        Tree tree = new Tree();

        tree.add(12);
        tree.add(5);
        tree.add(18);
        tree.add(2);
        tree.add(9);
        tree.add(15);
        tree.add(19);
        tree.add(13);
        tree.add(17);
        
        /*
         * 
         *    (5)
         *    / \
         *  (3) (7) 
         *  
         */
        
        System.out.println(Cozumler.doluDugumSayisi(tree.root));
    }
}
