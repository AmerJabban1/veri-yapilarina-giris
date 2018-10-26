package bolum06;

import bolum02.LinkedList;
import bolum02.Node;

public class HashTable {
    LinkedList[] table;
    boolean[] deleted;
    int N;
    
    public HashTable(int N) {
        table = new LinkedList[N];
        deleted = new boolean[N];
        for (int i = 0; i < N; i++) {
            table[i] = new LinkedList();
        }
        this.N = N;
    }
    
    int hash(int number) {
        return number % N;
    }
    
    Node search(int value) {
        int address = hash(value);
        return table[address].search(value);
    }
    
    void add(int value) {
        int address = hash(value);
        table[address].append(value);
    }
    
    void remove(int value) {
        int address = hash(value);
        Node node = table[address].search(value);
        if (node != null) {
            table[address].remove(value);
        }
    }
    
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(table[i] + " ");
        }
        sb.append("\n");
        return sb.toString();
    }
    
    public static void main(String[] args) {
        HashTable ht = new HashTable(10);
        for (int i = 1; i <= 10; i++) {
            ht.add(i);
        }
        System.out.println(ht);
    }
}
