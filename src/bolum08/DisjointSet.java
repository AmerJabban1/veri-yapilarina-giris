package bolum08;

public class DisjointSet {
    class Element {
        private int data;
        private int parent;
        private int depth;
        
        public Element(int data) {
            this.data = data;
            parent = data;
            depth = 1;
        }

        public int getData() {
            return data;
        }
        
        public int getParent() {
            return parent;
        }

    }
    
    private Element[] elements;
    private int size;
    
    public DisjointSet(int size) {
        elements = new Element[size];
        this.size = size;
    }
    
    public int find(int x) {
        if (elements[x].parent != x) {
            return find(elements[x].parent);
        }      
        return elements[x].parent;
    }
    
    public void union(int x, int y) {
        int set1 = find(x);
        int set2 = find(y);
        
        if (elements[set1].depth < elements[set2].depth) {
            elements[set1].parent = set2;
        } else {
            elements[set2].parent = set1;
            if (elements[set1].depth == elements[set2].depth) {
                elements[set1].depth++;
            }
        }
    }
    
    public Element[] getElements() {
        return elements;
    }
}
