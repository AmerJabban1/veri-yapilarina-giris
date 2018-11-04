package bolum06;

import java.util.Random;

import bolum02.LinkedList;

public class LinkedHashtable {
    private LinkedList[] table;
    private int capacity;
    int size;
    
    public LinkedHashtable(int capacity) {
        table = new LinkedList[capacity];
        this.capacity = capacity;
        this.size = 0;
    }
    
    int hash(int number) {
        return number % capacity;
    }
    
    boolean add(int number) {
        if (table[hash(number)] == null)
            table[hash(number)] = new LinkedList();
        table[hash(number)].append(number);
        size++;
        return true;
    }
    
    void remove(int number) {
        if (table[hash(number)].contains(number)) {
            table[hash(number)].remove(number);
            size--;
        }
    }
    
    public float loadFactor() {
        return (float)size / capacity;
    }
    
    public boolean isFull() {
        return size == capacity;
    }
    
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (LinkedList list : table) {
            sb.append(list).append("\n");
        }
        return sb.toString();
    }
    
    public static void main(String[] args) {
        Random random = new Random();
        LinkedHashtable lht = new LinkedHashtable(10);
        for (int i = 0; i < 10; i++) {
            lht.add(random.nextInt(100));
        }
        for (int i = 0; i < 10; i++) {
            lht.add(random.nextInt(100));
        }
        for (int i = 0; i < 10; i++) {
            lht.add(random.nextInt(100));
        }
        for (int i = 0; i < 10; i++) {
            lht.add(random.nextInt(100));
        }
        System.out.print(lht);
    }
}
