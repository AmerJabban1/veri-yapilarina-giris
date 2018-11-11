package bolum09;

import java.util.LinkedList;

class Element {
    private int src;
    private int dest;
    private int weight;
    public Element next;
    
    public Element(int src, int dest, int weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }
    public String toString() {
        return String.format("(%d, %d) [%d]", src, dest, weight);
    }
}

class List {   
    public Element head, tail;
    
    protected void append(Element element) {
        if (head == null) {
            head = element;
            tail = element;
            return;
        }
        tail.next = element;
        tail = element;
    }
    
    public int size() {
        Element temp = head;
        int size = 0;
        while (temp != null) {
            size++;
            temp = temp.next;
        }
        return size;
    }
}

public class Graph {
    
    private LinkedList<Element>[] edges;
    private int N;
    private VertexState[] state;
    
    public Graph(int N) {
        this.N = N;
        edges = new LinkedList[N];
        for (int i = 0; i < N; i++) {
            state = new VertexState[N];
            edges[i] = new LinkedList();
        }
        for (int i = 0; i < N; i++) {
            state[i] = VertexState.White;
        }
    }
    
    enum VertexState {
        White, Gray, Black
    }
    
    public void DFS(int s) {
        runDFS(s, state);
    }
    
    private void runDFS(int s, VertexState[] state) {
        state[s] = VertexState.Gray;
        System.out.println(edges[s]);
        for (int i = 0; i < edges[s].size(); i++) {
            if (state[i] == VertexState.White) {
                runDFS(i, state);
            }
        }
        state[s] = VertexState.Black;
    }
    
    public void addEdge(int src, int dest, int weight) {
        Element newElement = new Element(src, dest, weight);
        edges[src].add(newElement);
    }
}
