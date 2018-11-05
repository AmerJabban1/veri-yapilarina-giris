package bolum07;

public class Cozumler {
    
    // 2. Bir yiginda belirli bir x degerinden buyuk tum sayilari bulan fonksiyonu yaziniz.
    private static void buyukDondur(BinaryHeap heap, int x) {
    // Veri yapisi zaten sirali oldugu icin bu yapiya array gibi yaklasabiliriz.
        int index = 0;        
        while (index < heap.size()) {
            if (heap.get(index) > x) {
                System.out.println(heap.get(index));
            }
            index++;
        }
    }
    
    // 3. Yigin veri yapisini ikili arama agaci veri yapisi gibi baglantilar ile ifade ediniz.
    
    
    public static void main(String[] args) {
        
    }
}
