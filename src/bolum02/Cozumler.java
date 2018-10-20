package bolum02;
public class Cozumler {
    
    // 1. Tam sayilar iceren bir bagli listedeki en kucuk sayiyi bulan fonksiyonu yaziniz.
    static int enKucukBul(LinkedList list) {
        int min = Integer.MAX_VALUE;
        Node temp = list.head;
        while (temp != null) {
            if (temp.data < min)
                min = temp.data;
            temp = temp.next;
        }
        return min;
    }
    
    // 2. Verilen bir bagli listenin ikinci elemanini silen fonksiyonu yaziniz.
    static void ikinciyiSil(LinkedList list) {
        Node temp = list.head;
        temp.next = temp.next.next;
    }
    
    // 3. Verilen bir bagli listenin tek sira numarali elemanlarini ayri bir bagli listede
    // donduren bir fonksiyon yaziniz.
    static LinkedList tekNumaraliAyir(LinkedList list) {
        LinkedList newList = new LinkedList();        
        Node temp = list.head;
        int i = 0;
        while (temp != null) {
            if (i % 2 == 1)
                newList.append(temp.data);
            temp = temp.next;
            i++;
        }
        return newList;
    }
    
    // 4. Verilen bir bagli listenin cift sira numarali elemanlarini silen fonksiyonu yaziniz.
    static void ciftNumaraliSil(LinkedList list) {
        Node prev = list.head;
        int i = 0;
        while (prev.next != null) {
            if (i == 0)
                list.head = list.head.next;
            else if (i % 2 == 0)
                prev.next = prev.next.next;
            else
                prev = prev.next;
            i++;
        }
    }
    
    // 5. Verilen bir bagli listenin son elemaninin onune yeni bir eleman ekleyen fonksiyonu
    // yaziniz.
    static void sondanOnceEkle(LinkedList list, Node newNode) {
        Node temp = list.head;
        while (temp != null) {
            if (temp.next.next == null) {
                newNode.next = temp.next;
                temp.next = newNode;
                return;
            }
            temp = temp.next;
        }
    }
    
    // 6. Verilen siralanmis bir bagli listenin icine yeni bir sayiyi sirayi bozmadan ekleyen
    // fonksiyonu yaziniz.
    static void siraliEkle(LinkedList list, int x) {
        if (isSorted(list)) {
            Node newNode = new Node(x);
            if (list.head == null) {
                list.head = newNode;
                return;
            }
            if (x < list.head.data) {
                newNode.next = list.head;
                list.head = newNode;
                return;
            }
            
            Node temp = list.head;
            while (temp.next != null && temp.next.data < x) {
                temp = temp.next;
            }
            newNode.next = temp.next;
            temp.next = newNode;
        }
    }
    
    // 7. Verilen bir bagli listedeki i'ninci elemani silen bir fonksiyon yaziniz.
    static void ininciSil(LinkedList list, int i) {
        if (list.head != null && i >= 0 && i < size(list)) {
            if (i == 0) {
                list.head = list.head.next;
                return;
            }
            Node temp = list.head;
            int counter = 1;
            
            while (temp.next != null && counter < i) {
                temp = temp.next;
                counter++;
            }
            temp.next = temp.next.next;
        }
    }
    
    // 8. Verilen bir X elemaninin onundeki elemani silen fonksiyonu yaziniz.
    static void oncekiniSil(LinkedList list, int x) {
        // eleman basta ise
        /*
         * list.head.next.data == x
         *     list.head = list.head.next
         *     return
         */
        // ortada ise
        /*
         * Node temp = list.head;
         * while (temp.next.data != x) {
         *     temp = temp.next;
         * }
         * temp.next = temp.next.next;
         */
        
        if (!contains(list, x))
            return;        
        if (x == list.head.data)
            return;
        
        if (x == list.head.next.data) {
            list.head = list.head.next;
            return;
        }
        
        Node temp = list.head;
        while (temp.next.next.data != x) {
            temp = temp.next;
        }
        temp.next = temp.next.next;
    }
    
    // 9. Bir bagli listedeki verilen bir elemani n eleman ileriye tasiyan fonksiyonu yaziniz.
    static void tasi(LinkedList list, int x, int n) {
        if (list.head != null) {
            Node temp = list.head;
            Node swap = null;            
            
            if (x == list.head.data) {
                swap = list.head;
                list.head = list.head.next;
            } else {
                while (temp.next != null) {
                    if (temp.next.data == x) {
                        swap = temp.next;
                        temp.next = temp.next.next;
                        break;
                    }
                    temp = temp.next;
                }
            }
            int i = 0;
            while (i < n) {
                temp = temp.next;
                i++;
            }
            swap.next = temp.next;
            temp.next = swap;
            return;            
        }
    }
    
    // 10. Bir cift bagli listenin ortanca elemanini bulan fonksiyonu yaziniz.
    static Node ortanca(LinkedList list) {
        int size;
        if ((size = size(list)) == 1)
            return new Node(list.head.data);
        
        Node prev = list.head.prev;
        Node temp = list.head;        
        
        int i = 0;      
        while (i < (size / 2)) {
            prev = temp;
            temp = temp.next;
            i++;
        }
        
        if (size % 2 == 0)
            return new Node((prev.data + temp.data) / 2);
        else
            return new Node(temp.data);
    }
    
    // 11. Bir cift bagli listede verilen iki elemanin yerlerini degistiren fonksiyonu yaziniz.
    // Yazdiginiz fonksiyon, elemanlarin icerigini degil sadece baglantilarini degistirebilir.
    static void yerDegistir(LinkedList list, int a, int b) {
        if (!(a < b)) {
            swap(a, b);
        }
        if (list.head != null && contains(list, a) && contains(list, b) && a != b) {
            Node prev = list.head.prev;
            Node temp = list.head;            
            Node x = null;
            Node y = null;
            int i = -1;
            int j = -1;
            boolean f = false;
            boolean g = false;
            
            // Step 1: get the elements
            int counter = 0;
            while (temp != null && (!f || !g)) {
                if (temp.data == a) {
                    x = new Node(temp.data);
                    i = counter;
                    f = true;
                } else if (temp.data == b) {
                    y = new Node(temp.data);
                    j = counter;
                    g = true;
                }                
                temp = temp.next;
                counter++;
            }
            
            // Step 2: sort the elements by index            
            if (!(i < j)) {
                swap(i, j);
            }            
            
            // Step 3: swap them
            prev = list.head.prev;
            temp = list.head;
            f = false;
            g = false;
            counter = 0;
            while (temp != null && (!f || !g)) {
                if (counter == i) {
                    if (j - i == 1) {
                        Node swapper = temp.next;
                        temp.next = temp.next.next;
                        swapper.next = temp;
                        prev.next = swapper;
                        return;
                    }
                    y.next = temp.next;
                    if (i == 0) {                        
                        list.head = y;
                    } else {
                        prev.next = y;
                    }
                    f = true;
                }
                if (counter == j) {
                    x.next = temp.next;
                    if (j == 0){
                        list.head= x;
                    } else {
                        prev.next = x;
                    }
                    g = true;
                }
                
                prev = temp;
                temp = temp.next;
                counter++;
            }
        }
    }
    
    // 12. Bir cift bagli listenin belirli bir parcasini kesip diger bir listeye yapistirmak istiyoruz.
    // Kesmenin basladigi ve bittigi yer ile kopyalanacak yerin adreslerinin verildigini varsayarak bu
    // islemi yapan fonksiyonu yaziniz.
    static void kesYapistir(LinkedList sourceList, LinkedList destList, int head, int tail) {
        if (!(head < tail)) {
            swap(head, tail);
        }
        if (sourceList.head != null && contains(sourceList, head) && contains(sourceList, tail) && head != tail) {
            Node temp = sourceList.head;
            int i = -1;
            int j = -1;
            boolean f = false;
            boolean g = false;
            
            int counter = 0;
            while (temp != null && (!f || !g)) {
                if (temp.data == head) {
                    i = counter;
                    f = true;
                } else if (temp.data == tail) {
                    j = counter;
                    g = true;
                }
                temp = temp.next;
                counter++;
            }
            
            if (!(i < j)) {
                swap(i, j);
            }
            
            temp = sourceList.head;
            counter = 0;
            while (temp != null) {
                if (counter == i) {
                    int p = 0;
                    while (p <= (j - i)) {
                        destList.append(temp.data);
                        temp = temp.next;
                        p++;
                    }
                    break;
                }
                temp = temp.next;
                counter++;
            }
            
            temp = sourceList.head;
            counter = 0;
            while (temp != null && counter <= (j - i)) {
                if (counter == i) {
                    int p = 0;
                    while (p <= (j - 1)) {
                        sourceList.remove(temp.data);
                        temp = temp.next;
                        p++;
                    }
                    return;
                }
                
                temp = temp.next;
                counter++;
            }
        }
    }
    
    // 13. Size bir N sayisi veriliyor. N sayisinin asal carpanlarini ureten ve onlari bir bagli liste
    // icinde donduren fonksiyonu yaziniz.    
    static LinkedList asalCarpanlar(int N) {        
        LinkedList factors = new LinkedList();
        for (int i = 2; i <= N; i++) {
            if (N % i == 0) {
                factors.append(i);
            }
        }
        
        LinkedList primeFactors = new LinkedList();
        Node temp = factors.head;
        while (temp != null) {
            if (isPrime(temp.data)) {
                primeFactors.append(temp.data);
            }
            temp = temp.next;
        }
        return primeFactors;
    }
    
    // 14. Verilen bir listenin icinden N'ye bolunen tum elemanlari silen ve yeni bir listeye ekleyip
    // o listeyi donduren fonksiyonu yaziniz.
    static LinkedList katlariSil(LinkedList list, int N) {
        Node prev = null;
        Node temp = list.head;
        
        LinkedList factors = new LinkedList();
        while (temp != null) {
            if (temp.data % N == 0) {
                factors.append(temp.data);
                if (prev != null)
                    prev.next = temp.next;
            }
            prev = temp;
            temp = temp.next;
        }
        return factors;
    }
    
    // 15. Verilen bir listeyi tersine ceviren ve yeni bir liste olarak donduren fonksiyonu yaziniz.
    static LinkedList tersCevir(LinkedList list) {
        Node prev = null;
        Node temp = list.head;
        while (temp != null) {
            Node next = temp.next;
            temp.next = prev;
            prev = temp;
            temp = next;
        }
        list.head = prev;
        return list;
    }
    
    // 16. Verilen bir listenin palindrom olup olmadigini kontrol eden fonksiyonu yaziniz.
    static boolean palindrom(LinkedList list) {
        final int size = size(list);
        int[] array = new int[size];
        
        int index = 0;
        Node temp = list.head;
        while (index < size) {
            array[index] = temp.data;
            temp = temp.next;
            index++;
        }

        for (int i = 0, j = size - 1; i < size; i++, j--) {
            if (array[i] != array[j]) {
                return false;
            }
        }
        return true;
    }
    
    // 17. Verilen iki siralanmis bagli listenin ortak elemanlarini bulan fonksiyonu yaziniz.
    static LinkedList kesisim(LinkedList alpha, LinkedList beta) {
        Node tempA = alpha.head;
        Node tempB = beta.head;
        LinkedList common = new LinkedList();

        while (tempA != null) {
            while (tempB != null) {
                if (tempA.data == tempB.data) {
                    common.append(tempA.data);
                }
                tempB = tempB.next;
            }
            tempB = beta.head;
            tempA = tempA.next;
        }        
        return common;
    }
    
    private static boolean isPrime(int n) {
        if (n == 2)
            return true;
        if (n < 2 || n % 2 == 0)
            return false;
        for (int i = 2; i < n; i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }
    
    private static void swap(int a, int b) {
        int swap = a;
        a = b;
        b = swap;
    }
    
    private static boolean contains(LinkedList list, int n) {
        Node temp = list.head;
        while (temp != null) {
            if (temp.data == n) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }
    
    private static boolean isSorted(LinkedList list) {
        Node temp = list.head;
        int n;
        while (temp.next != null) {
            n = temp.data;
            if (!(n < temp.next.data || n == temp.next.data)) {
                return false;
            }
            temp = temp.next;
        }
        return true;
    }
    
    private static int size(LinkedList list) {
        Node temp = list.head;
        int size = 0;
        while (temp != null) {
            temp = temp.next;
            size++;
        }
        return size;
    }
}
