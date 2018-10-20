package development;

public class BST {
    class Node {
        int data;
        Node left, right;
        
        public Node(int data) {
            this.data = data;
        }
        
        public Node getMin() {
            if (left == null)
                return this;
            else
                return left.getMin();
        }
        
        public Node getMax() {
            if (right == null)
                return this;
            else
                return right.getMax();
        }
    }
    
    Node root;
    
    void add(int data) {
        Node newNode = new Node(data);
        if (root == null) {
            root = newNode;
            return;
        }
        
        Node temp = root;
        Node swap = null;
        while (temp != null) {
            swap = temp;
            if (data < temp.data) {
                temp = temp.left;
            } else {
                temp = temp.right;
            }
        }
        
        if (data < swap.data) {
            swap.left = newNode;
        } else {
            swap.right = newNode;
        }
    }
    
    void remove(int data) {
        if (root == null) {
            return;
        } else if (data == root.data) {
            if (root.left == null && root.right == null) {
                root = null;
                return;
            } else if (root.right != null) {
                Node leftSubtree = root.left;
                root = root.right;
                Node leftMin = root.getMin();
                leftMin.left = leftSubtree;
            } else if (root.left != null) {
                root = root.left;
            }
        }
            
        Node temp = root;
        Node parent = null;
        
        while (temp != null) {
            if (data == temp.data) {
                // If the node has no children.
                if (temp.left == null && temp.right == null) {
                    if (temp.data < parent.data) {
                        parent.left = null;
                    } else {
                        parent.right = null;
                    }
                    return;
                }
                
                // If the node has one child.
                if (temp.left != null && temp.right == null) {
                    parent.left = temp.left;
                    return;
                } else if (temp.left == null && temp.right != null) {
                    parent.right = temp.right;
                    return;
                }
                
                // If the node has two children.
                if (temp.left != null && temp.right != null) {
                    if (temp.data > parent.data) {
                        parent.right = temp.right.getMin();
                        Node subtree = temp.left;
                        temp = parent.right;
                        parent.left = subtree;
                    } else if (temp.data < parent.data) {
                        parent.left = temp.right.getMax();
                        Node subtree = temp.left;
                        temp = parent.left;
                        temp.left = subtree;
                    }
                }
            }
            if (data < temp.data) {
                parent = temp;
                temp = temp.left;
            } else {
                parent = temp;
                temp = temp.right;
            }
        }
    }
    
    void printInOrder() {
        printInOrder(root);
    }
    
    void printInOrder(Node root) {
        if (root != null) {
            System.out.print(root.data + " ");
            printInOrder(root.left);
            printInOrder(root.right);
        }
    }
    
    public static void main(String[] args) {
    }
}
