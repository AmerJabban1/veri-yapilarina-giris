package bolum05;

public class Tree {
    Node root;
    
    void add(int data) {
        Node a = root;
        Node b = null;
        Node newNode = new Node(data);
        
        while (a != null) {
            b = a;
            if (data < a.data) {
                a = a.left;
            } else {
                a = a.right;
            }
        }
        if (b == null) {
            root = newNode;
        } else {
            if (data < b.data) {
                b.left = newNode;
            } else {
                b.right = newNode;
            }
        }
    }
    
    void remove(int data) {
        Node a = root;
        Node b = null;
        
        while (a.data != data) {
            if (data < a.data) {
                a = a.left;
            } else {
                a = a.right;
            }
        }
        while (true) {
            if (a.left != null) {
                b = a.left.getMaxIterative();
            }
            if (b == null && a.right != null) {
                b = a.right.getMinIterative();
            }
            if (b == null) {
                break;
            }
            a.data = b.data;
            a = b;
        }
    }
    
    Node searchIterative(int x) {
        Node temp = root;
        while (temp != null) {
            if (temp.data == x) {
                return temp;
            }
            if (x < temp.data) {
                temp = temp.left;
            } else {
                temp = temp.right;
            }
        }
        return null;
    }
}
