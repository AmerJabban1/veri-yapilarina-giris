package bolum06;

import bolum02.LinkedList;
import bolum02.Node;
import bolum03.ArrayStack;
import bolum03.Queue;

public class Cozumler {
    
    // 2. Verilen bir bagli listenin karma tablosundaki adresini bulan fonksiyonu yaziniz.
    int karma(LinkedList list) {
        Node temp = list.head;
        int size = list.size();
        
        int result = 0;
        while (temp != null) {
            result += hash(temp.getData(), size);
        }
        return result;
    }
    
    // 3. Verilen bir kuyruk veri yapisinin karma tablosundaki adresini bulan fonksiyonu yaziniz.
    int karma(Queue queue) {
        int size = queue.size();
        int result = 0;
        while (queue.peek() != null) {
            result += hash(queue.dequeue(), size);
        }
        return result;
    }
    
    // 4. Verilen bir cikin veri yapisini karma tablosundaki adresini bulan fonksiyonu yaziniz.
    int karma(ArrayStack stack) {
        int size = stack.size();
        int result = 0;
        while (stack.peek() != null) {
            result += hash(stack.pop().intValue(), size);
        }
        return result;
    }
    
    // 5. Veri yapisi olarak Ikili Arama Agaci kullanan bir karma tablosunda belirli bir sayiyi
    // arayan fonksiyonu yaziniz.
    
    
    int hash(int n, int cap) {
        return n % cap;
    }
}
