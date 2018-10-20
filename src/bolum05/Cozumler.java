package bolum05;

public class Cozumler {
    
    // 4. Verilen bir ikili arama agacindaki sayilari buyukten kucuge ekrana yazan
    // fonksiyonu yaziniz.
    static void sirala(Tree tree) {
        tree.root.printPreOrder();
    }
    
    // 5. Verilen bir ikili arama agacindaki dolu dugum sayisini hesaplayan fonksiyonu
    // yaziniz. Bir dugumun hem sol hem sag cocugu varsa o dugume dolu dugum denir
    static int doluDugumSayisi(Tree tree) {
        int n = 0;
        Node temp = tree.root;
        if (temp.left != null && temp.right != null) {
            n++;
            
        }
        return n;
    }
}
