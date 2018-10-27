package bolum06;

import java.util.Random;

public class Hashtable {    
    private Integer[] table;
    private int capacity;
    private int size;
    
    public Hashtable(int capacity) {
        table = new Integer[capacity];
        this.capacity = capacity;
        this.size = 0;
    }
    
    int hash(int number) {
        return number % capacity;
    }
    
    boolean add(int number) {
        if (table[hash(number)] != null) {
            System.out.printf(">> Hata: [%d] sayisinin eklenmeye calisildigi [%d] indisi dolu!\n", number, hash(number));
            return false;
        }
        table[hash(number)] = new Integer(number);
        size++;
        return true;
    }
    
    void remove(int number) {
        if (table[hash(number)] != null) {
            table[hash(number)] = null;
            size--;
        }
    }
    
    public float loadFactor() {
        return (float)size / capacity;
    }
    
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Integer integer : table) {
            if (integer != null)
                sb.append(integer).append(" ");
        }
        return sb.toString();
    }
    
    public static void main(String[] args) {
        Random random = new Random();
        Hashtable ht = new Hashtable(10);
        for (int i = 0; i < 7; i++) {
            ht.add(random.nextInt(100));
        }
        System.out.println(ht);
        System.out.println(ht.loadFactor());
    }
}
