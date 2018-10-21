package bolum05;

public class Cozumler {
    
    // 4. Verilen bir ikili arama agacindaki sayilari buyukten kucuge ekrana yazan
    // fonksiyonu yaziniz.
    static void sirala(Tree tree) {
        tree.root.printPreOrder();
    }
    
    // 5. Verilen bir ikili arama agacindaki dolu dugum sayisini hesaplayan fonksiyonu
    // yaziniz. Bir dugumun hem sol hem sag cocugu varsa o dugume dolu dugum denir
    static int doluDugumSayisi(Node root) {
        if (root.left != null && root.right != null) {
            return 1 + doluDugumSayisi(root.left) + doluDugumSayisi(root.right);
        } else
            return 0;
    }
    
    // 6. Verilen bir ikili arama agacindaki tek dugum sayisini hesaplayan fonksiyonu
    // yaziniz. Bir dugumun degeri tek sayiysa o dugume tek dugum denir.
    static int tekDugum(Node root) {
        if (root != null) {
            if (isOdd(root.data)) {
                return 1 + tekDugum(root.left) + tekDugum(root.right);
            } else
                return 0 + tekDugum(root.left) + tekDugum(root.right);
        } else
            return 0;
    }
    
    private static boolean isOdd(int n) {
        return n % 2 == 1;
    }
}
